package ph.com.alliance.proj2_group1.ticket_category.service;

import java.util.List;

import ph.com.alliance.proj2_group1.ticket_category.entity.TicketCategory;

public interface ITicketCategoryService {
	
	public List<TicketCategory> getAllCategories(); 
	public TicketCategory getCategorybyID(Integer id);
	
}

