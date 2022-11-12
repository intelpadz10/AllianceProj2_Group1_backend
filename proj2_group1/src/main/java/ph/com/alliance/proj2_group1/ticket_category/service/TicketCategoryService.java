package ph.com.alliance.proj2_group1.ticket_category.service;

import ph.com.alliance.proj2_group1.ticket_category.entity.Ticket_Category;
import ph.com.alliance.proj2_group1.ticket_category.repository.TicketCategoryRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketCategoryService implements ITicketCategoryService {

	@Autowired
	private TicketCategoryRepository ticketCategoryJpaRepository;

	public List<Ticket_Category> getAllCategories() {
		return ticketCategoryJpaRepository.findAll();
	}

	public Ticket_Category getCategorybyID(Integer id) {
		return ticketCategoryJpaRepository.getReferenceById(id);
	}

}
