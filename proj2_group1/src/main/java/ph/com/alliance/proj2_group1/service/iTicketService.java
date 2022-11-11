package ph.com.alliance.proj2_group1.service;

import ph.com.alliance.proj2_group1.entity.Ticket;

public interface iTicketService {
	public String findById(final int id);
	public String findAll();

	public int createTicket(final Ticket ticket);

	public int deleteByID(final int id);
	public int update(final Ticket ticket);
	public int updateAll(final Ticket ticket);
}
