package ph.com.alliance.proj2_group1.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.message.TicketMessages;
import ph.com.alliance.proj2_group1.ticket.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("/ticket/create")
	@ResponseBody
	public ApiResponse saveTicket(Ticket ticket) {

		Ticket savedTicket = ticketService.saveTicket(ticket);

		if (savedTicket != null) {
			return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}

	@GetMapping("/ticket/all")
	@ResponseBody
	public ApiResponse showTickets() {

		List<Ticket> savedtickets = ticketService.getAllTickets();

		if (savedtickets != null) {
			return ApiResponse.CreateSuccess(savedtickets, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE +"CAUSE:" +TicketMessages.TICKET_FAILED_RETRIEVED);

	}

	@GetMapping("/ticket/{id}")
	@ResponseBody
	public ApiResponse showTicket(@PathVariable final int id) {

		Ticket savedTicket = ticketService.getTicketbyId(id);

		if (savedTicket != null) {
			return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE +"CAUSE:" +TicketMessages.TICKET_FAILED_RETRIEVED);
	}

	@RequestMapping(path = "/ticket/{id}/update", method = { RequestMethod.POST, RequestMethod.PATCH,
			RequestMethod.PUT })
	@ResponseBody
	public ApiResponse update(@PathVariable int id, Ticket newticket) {

		Ticket savedTicket = ticketService.getTicketbyId(id);

		if (savedTicket != null) {
			if (savedTicket.getTicket_id() == newticket.getTicket_id()) {
				return saveTicket(newticket);
			} else {
				return ApiResponse.CreateError (TicketMessages.GENERIC_UNSUCCESSFUL_SAVE+" ERROR: " +TicketMessages.TICKET_ID_MISMATCH);
			}
		} else {
			return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE);
		}

	}
	/*
	 * private iTicketService service;
	 * 
	 * @Autowired public TicketController(final iTicketService service) {
	 * this.service = service; }
	 * 
	 * 
	 * @RequestMapping("/ticket/{id}") public String getTicket(@PathVariable final
	 * int id) { return service.findById(id); }
	 * 
	 * 
	 * @GetMapping("/ticket") public String getAllTickets() { return
	 * service.findAll(); }
	 * 
	 * @RequestMapping(path ="/ticket/{id}", method = {RequestMethod.POST,
	 * RequestMethod.PATCH, RequestMethod.PUT}) public String update(
	 * 
	 * @PathVariable final int id,
	 * 
	 * @RequestParam("status") final String status,
	 * 
	 * @RequestParam("assignee") final int assignee,
	 * 
	 * @RequestParam("subject") final String subject ,
	 * 
	 * @RequestParam("description") final String description,
	 * 
	 * @RequestParam("tracker") final String tracker,
	 * 
	 * @RequestParam("class") final String classType ) { if(service.updateAll(new
	 * Ticket( id, assignee, status, subject, description,tracker,classType))== 1 ){
	 * return "Successful Update!"; } else if (service.update(new Ticket( id,
	 * assignee, status, subject, description,tracker,classType)) == 1){ return
	 * "Successful Update"; } else { return "Unsuccessful Update"; }
	 * 
	 * }
	 * 
	 * @PostMapping("/ticket") public String create(
	 * 
	 * @RequestParam("id") final int ticketID,
	 * 
	 * @RequestParam("assignee") final int assignee,
	 * 
	 * @RequestParam("status") String status,
	 * 
	 * @RequestParam("subject") String subject,
	 * 
	 * @RequestParam("description") String description,
	 * 
	 * @RequestParam("tracker") String tracker,
	 * 
	 * @RequestParam("classType") String classType ) { String success; if
	 * (service.createTicket(new Ticket( ticketID, assignee, status, subject,
	 * description, tracker, classType))<= 0) { success =
	 * "failed creation of account"; return success; } else { success =
	 * "account has been created" ; return success; } }
	 * 
	 * @DeleteMapping("/ticket/delete/{id}") public int delete(@PathVariable final
	 * int id) throws IOException { return service.deleteByID(id); }
	 */

}
