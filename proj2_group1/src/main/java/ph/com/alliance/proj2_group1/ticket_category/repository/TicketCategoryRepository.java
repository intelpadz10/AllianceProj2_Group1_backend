package ph.com.alliance.proj2_group1.ticket_category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.ticket_category.entity.Ticket_Category;

@Repository
public interface TicketCategoryRepository extends JpaRepository<Ticket_Category, Integer> {

}
