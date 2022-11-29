package ph.com.alliance.proj2_group1.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ApiResponse update(@PathVariable int id, Ticket newticket) {


		try {
			Ticket savedTicket = ticketService.updateTicket(newticket);
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
	public ApiResponse updateStatus(Ticket ticket) {

		try {
			Ticket savedTicket = ticketService.updateTicket(ticket);
			if (savedTicket != null)
				return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_UPDATED);
			else
				return ApiResponse.CreateError(TicketMessages.TICKET_FAILED_UPDATE);
		} catch (Exception e) {
			return ApiResponse.CreateError(TicketMessages.TICKET_FAILED_UPDATE + e.getMessage());
		}

	}
}
