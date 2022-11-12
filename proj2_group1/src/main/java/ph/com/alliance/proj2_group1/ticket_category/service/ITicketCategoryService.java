package ph.com.alliance.proj2_group1.ticket_category.service;

import java.util.List;

import ph.com.alliance.proj2_group1.ticket_category.entity.Ticket_Category;

public interface ITicketCategoryService {
	
	public List<Ticket_Category> getAllCategories(); 
	public Ticket_Category getCategorybyID(Integer id);
	
}

