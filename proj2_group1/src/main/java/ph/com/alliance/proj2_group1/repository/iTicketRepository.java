package ph.com.alliance.proj2_group1.repository;

import java.util.List;

import ph.com.alliance.proj2_group1.entity.Ticket;

public interface iTicketRepository {
	public Ticket findById(final int id);
	public List<Ticket> findAll(); 
	public int createTicket(final Ticket user); 

	public int deleteByID(final int id);
	public int updateByIDAll(final Ticket ticket);
	public int updateByIDStatus(final Ticket ticket);
	public int updateByIDAssignee(final Ticket ticket);
	public int updateByIDAssigneeStatus(final Ticket ticket);
}