package ph.com.alliance.proj2_group1.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


	/*
	 * Status Codes 1 - pending 2 - Working 3 - On Hold 4 - Completed 5 - Cancelled
	 * 6 - Deleted
	 */
	@Query(value = "SELECT *  FROM ticket where status_id = :status", nativeQuery = true)
	List<Ticket> findAllTicketsByStatusID(@Param("status") int status_id);

	@Query(value = "SELECT * FROM ticket where status_id = 1 AND sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllPendingTicketsBySelectedSender(@Param("sender") int sender_id);
	
	@Query(value = "SELECT * FROM ticket  where sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllTicketsBySelectedSender(@Param("sender") int sender_id);
	
	@Query (value ="SELECT * FROM ticket WHERE deadline_at < NOW()", nativeQuery = true)
	List<Ticket> findAllAgingTickets ();
	
	@Query (value = "SELECT * FROM ticket WHERE sender_id = :sender AND deadline_at < NOW()", nativeQuery = true)
	List<Ticket> findAllAgingTicketsBySender(@Param("sender") int sender_id);
	
	@Query (value ="SELECT * FROM ticket WHERE ticket_category = :category", nativeQuery = true)
	List<Ticket> findAllTicketsByCategory(@Param("category") int category_id);

	@Query (value ="SELECT * FROM ticket WHERE ticket_category = :category AND sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllTicketsByCategoryandSenderID(@Param("category") int category_id,@Param("sender") int sender_id);

	@Query (value = "SELECT * from ticket where assignee_id = :assignee")
	List<Ticket>findAllTicketsbyAssignee(@Param ("asignee") int assignee_id);
}
