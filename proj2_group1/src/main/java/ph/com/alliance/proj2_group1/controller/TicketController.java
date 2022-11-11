package ph.com.alliance.proj2_group1.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.entity.Ticket;
import ph.com.alliance.proj2_group1.service.iTicketService;

@RestController
public class TicketController {
		
	private iTicketService service;
		@Autowired
		public TicketController(final iTicketService service)
		{
			this.service = service;
		}
		

		@RequestMapping("/ticket/{id}")
		public String getTicket(@PathVariable final int id)
		{
			return service.findById(id);
		}
		
		
		@GetMapping("/ticket")
		public String getAllTickets()
		{
			return service.findAll();
		}
		
		@RequestMapping(path ="/ticket/{id}", method = {RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT})
		public String update(
				@PathVariable final int id, 
				@RequestParam("status") final String status, 
				@RequestParam("assignee") final int assignee,
				@RequestParam("subject") final String subject ,
				@RequestParam("description") final String description,
				@RequestParam("tracker") final String tracker,
				@RequestParam("class") final String classType
			) 
		{
				if(service.updateAll(new Ticket( id, assignee, status, subject, description,tracker,classType))== 1 ){
					return "Successful Update!";
				}
				else if (service.update(new Ticket( id, assignee, status, subject, description,tracker,classType)) == 1){
					return "Successful Update";
				} else {
					return "Unsuccessful Update";
				}
			
		}
		
		@PostMapping("/ticket")
		public String create(
				@RequestParam("id") final int ticketID,
				@RequestParam("assignee") final int assignee,
				@RequestParam("status") String status,
				@RequestParam("subject") String subject,
				@RequestParam("description") String description,
				@RequestParam("tracker") String tracker,
				@RequestParam("classType") String classType								
				) {
			String success;
			if (service.createTicket(new Ticket( ticketID, assignee, status, subject, description, tracker, classType))<= 0) {
				success = "failed creation of account";
				return success;
			} else {
				success = "account has been created" ;
				return success;
			}
		}

		@DeleteMapping("/ticket/delete/{id}")
		public int delete(@PathVariable final int id) throws IOException
		{
			return service.deleteByID(id);
		}
}
