package ph.com.alliance.proj2_group1.ticket.service;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.google.gson.Gson;

@Service
public class TicketService implements ITicketService{

	@Autowired
	private TicketRepository ticketJpaRepository;

	public Ticket saveTicket(Ticket ticket) {
		return ticketJpaRepository.saveAndFlush(ticket);
	}

}

/*
@Service
public class TicketService implements iTicketService{
	
	private iTicketRepository repository;
	private Gson gson;
	
	@Autowired
	public TicketService(final iTicketRepository repository)
	{
		this.repository = repository;
		this.gson = new Gson();
	}
	
	public String findById(final int id)
	{
		return gson.toJson(repository.findById(id));
	}
	
	public String findAll()
	{
		return gson.toJson(repository.findAll());
	}

	
	public int update(final Ticket ticket)
	{
		
		if (ticket.getAssignee()!= 0 && ticket.getStatus() != "") {
			return repository.updateByIDAssigneeStatus(ticket);
		}else if (ticket.getStatus() != "") {
			return repository.updateByIDStatus(ticket);
		} else if(ticket.getAssignee()!= 0){
			return repository.updateByIDAssignee(ticket); 
		}else{
			return 0;
		}
	}

	public int updateAll (final Ticket ticket) {
		if (ticket.getAssignee()!= 0 && ticket.getStatus() != "" && (ticket.getClassType() !="" && ticket.getTracker() != "" && ticket.getSubject() != "" && ticket.getDescription() != "")) {
		return repository.updateByIDAll(ticket);
		}else {
			return 0;
			}
	}
	
	public int createTicket(final Ticket ticket) {
		final int result = repository.createTicket(ticket);
		return (result > 0) ? 1: 0;
	}
	
	public int deleteByID(final int id)
	{
		return repository.deleteByID(id);
	}
	
}

*/