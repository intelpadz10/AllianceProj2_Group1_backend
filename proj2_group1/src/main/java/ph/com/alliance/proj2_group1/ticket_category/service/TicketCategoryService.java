package ph.com.alliance.proj2_group1.ticket_category.service;

import ph.com.alliance.proj2_group1.ticket_category.entity.TicketCategory;
import ph.com.alliance.proj2_group1.ticket_category.repository.TicketCategoryRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketCategoryService implements ITicketCategoryService {

	@Autowired
	private TicketCategoryRepository ticketCategoryJpaRepository;

	public List<TicketCategory> getAllCategories() {
		return ticketCategoryJpaRepository.findAll();
	}

	public TicketCategory getCategorybyID(Integer id) {
		return ticketCategoryJpaRepository.getReferenceById(id);
	}

}
