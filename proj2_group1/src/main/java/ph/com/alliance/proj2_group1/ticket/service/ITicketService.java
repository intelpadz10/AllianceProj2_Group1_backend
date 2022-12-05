package ph.com.alliance.proj2_group1.ticket.service;

import java.util.List;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;

public interface ITicketService {
	
	public Ticket saveTicket(Ticket ticket);
	public List<Ticket> getAllTickets();
	public List<Ticket> getAllAgingTickets();
	
	
	public List<Ticket> getAllTicketsByCategory(int category);
	public List<Ticket> getAllTicketsByCategoryAndSenderID(int category , int sender_id);
	public List<Ticket> getAllAgingTicketsBySenderID(int sender_id);
	public Ticket getTicketbyId(Integer id);
	public Ticket updateTicket (Integer id, Ticket ticket);	
	public String deleteTicket(Ticket ticket);
}

/*
public interface iTicketService {
	public String findById(final int id);
	public String findAll();

	public int createTicket(final Ticket ticket);

	public int deleteByID(final int id);
	public int update(final Ticket ticket);
	public int updateAll(final Ticket ticket);
}

*/