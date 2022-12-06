package ph.com.alliance.proj2_group1.ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.export.service.CsvExportService;
import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.message.TicketMessages;
import ph.com.alliance.proj2_group1.ticket.service.TicketService;
import ph.com.alliance.proj2_group1.ticket_category.entity.Ticket_Category;
import ph.com.alliance.proj2_group1.ticket_category.service.TicketCategoryService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketCategoryService categoryService;
	
	@Autowired
    private  CsvExportService csvExportService;

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

		return ApiResponse.CreateError(
				TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + TicketMessages.TICKET_FAILED_RETRIEVED);

	}
	
	@GetMapping("/ticket/all/aging")
	@ResponseBody
	public ApiResponse showAgingTickets() {

		List<Ticket> savedtickets = ticketService.getAllAgingTickets();

		if (savedtickets != null) {
			return ApiResponse.CreateSuccess(savedtickets, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(
				TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + TicketMessages.TICKET_FAILED_RETRIEVED);

	}
	@GetMapping("/ticket/all/sender/{id}")
	@ResponseBody
	public ApiResponse showTickets(@PathVariable final int id) {

		List<Ticket> savedtickets = ticketService.getAllTicketsofSender(id);

		if (savedtickets != null) {
			return ApiResponse.CreateSuccess(savedtickets, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(
				TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + TicketMessages.TICKET_FAILED_RETRIEVED);

	}
	

	
	@GetMapping("/ticket/all/sender/{id}/aging")
	@ResponseBody
	public ApiResponse showAgingTickets(@PathVariable final int id) {

		List<Ticket> savedtickets = ticketService.getAllAgingTicketsBySenderID(id);

		if (savedtickets != null) {
			return ApiResponse.CreateSuccess(savedtickets, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(
				TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + TicketMessages.TICKET_FAILED_RETRIEVED);

	}
	

	@GetMapping("/ticket/all/status/{status}")
	@ResponseBody
	public ApiResponse showTicketsWithStatus(@PathVariable int status) {

		List<Ticket> savedtickets = ticketService.getTicketsbyStatus(status);

		if (savedtickets != null) {
			return ApiResponse.CreateSuccess(savedtickets, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(
				TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + TicketMessages.TICKET_FAILED_RETRIEVED);

	}
	
	@GetMapping("/ticket/all/category/{category}")
	@ResponseBody
	public ApiResponse showTicketviaCategory(@PathVariable int category) {

		List<Ticket> savedtickets = ticketService.getAllTicketsByCategory(category);

		if (savedtickets != null) {
			return ApiResponse.CreateSuccess(savedtickets, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}

		return ApiResponse.CreateError(
				TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + TicketMessages.TICKET_FAILED_RETRIEVED);

	}

	@GetMapping("/ticket/{id}")
	@ResponseBody
	public ApiResponse showTicket(@PathVariable final int id) {
		
			Ticket savedTicket = ticketService.getTicketbyId(id);
			if (savedTicket != null) {
				return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_RETRIEVED);
			} else {
				return ApiResponse.CreateError(
						TicketMessages.GENERIC_UNSUCCESSFUL_SAVE + " ERROR: " + TicketMessages.TICKET_ID_MISMATCH);
			}
			
	}

	@PostMapping(path = "/ticket/{id}/update")
	@ResponseBody
	public ApiResponse update(@PathVariable Integer  id, Ticket newticket) {


		try {
			Ticket savedTicket = ticketService.updateTicket(id,newticket);
			if (savedTicket != null)
				return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_UPDATED);
			else
				return ApiResponse.CreateError(TicketMessages.TICKET_FAILED_UPDATE);
		} catch (Exception e) {
			return ApiResponse.CreateError(TicketMessages.TICKET_FAILED_UPDATE + e.getMessage());
		}

	}

	@PostMapping(path = "/ticket/{id}/update-status")
	@ResponseBody
	public ApiResponse updateTicketStatus(@PathVariable Integer  id, Ticket ticket) {

		try {
			Ticket savedTicket = ticketService.updateTicket(id, ticket);
			if (savedTicket != null)
				return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_UPDATED);
			else
				return ApiResponse.CreateError(TicketMessages.TICKET_FAILED_UPDATE);
		} catch (Exception e) {
			return ApiResponse.CreateError(TicketMessages.TICKET_FAILED_UPDATE + e.getMessage());
		}
	}
	
	@DeleteMapping (path = "/ticket/{id}")
	@ResponseBody
	public ApiResponse deleteTicketStatus (@PathVariable Integer  id, Ticket ticket) {
		String status;
		try {
			if (id == ticket.getId()) {
			 status = ticketService.deleteTicket(ticket);
			} else  status = "Ticket Mismatch";
			if (status == "Success Delete") 
				return ApiResponse.CreateSuccess("Ticket "+ticket.getId()+" has been successfully deleted!");
			else 
				return ApiResponse.CreateError(status);
		}catch (Exception e) {
			return ApiResponse.CreateError("Error in e: "+ e);
		}
	}
	
	//REQUEST CSV HERE
	
	@RequestMapping(path = "/tickets/csv")
    public void getAllTicketstoCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"AllTickets.csv\"");
        csvExportService.printAllTicketstoCSV(servletResponse.getWriter());
    }
	
	@RequestMapping(path = "/tickets/aging/csv")
    public void getAllAgingTicketstoCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"AgingTickets.csv\"");
        csvExportService.printAllAgingTicketstoCSV(servletResponse.getWriter());
    }
	
	@RequestMapping (path = "/tickets/aging/category/{id}/csv")
	public void getAllAgingTicketsbyCategorytoCSV(HttpServletResponse servletResponse,@PathVariable Integer  id ) throws IOException {
        Ticket_Category category = categoryService.getCategorybyID(id);
		servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"AgaingTicketsofthe"+category.getTicketCategory_name()+"Category.csv\"");
        csvExportService.printAllAgingTicketsbyCategorytoCSV(servletResponse.getWriter(),category);
    }
}
