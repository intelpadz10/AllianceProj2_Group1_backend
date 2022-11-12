package ph.com.alliance.proj2_group1.ticket_category.service;

import java.util.List;

import ph.com.alliance.proj2_group1.ticket_category.entity.TicketCategory;

public interface ITicketCategoryService {
	
	public List<TicketCategory> loadValues(); 
	public TicketCategory loadValue(Integer id);
	
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