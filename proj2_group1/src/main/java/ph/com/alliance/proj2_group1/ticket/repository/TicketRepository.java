package ph.com.alliance.proj2_group1.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

<<<<<<< HEAD
	@Query(value = "SELECT * FROM ticket where assignee_id = :assignee", nativeQuery = true)
	List<Ticket> findAllTicketsViaAssignee(@Param("assignee") int assignee);
=======
>>>>>>> edits2

	/*
	 * Status Codes 1 - pending 2 - Working 3 - On Hold 4 - Completed 5 - Cancelled
	 * 6 - Deleted
	 */
	@Query(value = "SELECT *  FROM ticket where status_id = :status", nativeQuery = true)
<<<<<<< HEAD
	List<Ticket> findAllTicketsByStatusID(@Param("status") int status_id);

=======
	List<Ticket> findAllStatusTicket(@Param("status") int status_id);
	
	@Query(value = "SELECT * FROM ticket where status_id = :status AND sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllSenderTicketsviaStatus(@Param("status") int  status_id, @Param("sender") int sender_id);
	
>>>>>>> edits2
	@Query(value = "SELECT * FROM ticket where status_id = 1 AND sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllPendingSelectedSenderTickets(@Param("sender") int sender_id);
	

	@Query(value = "SELECT * FROM ticket  where sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllTicketsBySelectedSender(@Param("sender") int sender_id);
	
	@Query (value ="SELECT * FROM ticket WHERE deadline_at < NOW()", nativeQuery = true)
	List<Ticket> findAllAgingTickets ();
	
<<<<<<< HEAD
	@Query (value = "SELECT * FROM ticket WHERE sender_id = :sender AND deadline_at < NOW()", nativeQuery = true)
	List<Ticket> findAllAgingTicketsBySender(@Param("sender") int sender_id);
	
	@Query (value ="SELECT * FROM ticket WHERE ticket_category = :category", nativeQuery = true)
	List<Ticket> findAllTicketsByCategory(@Param("category") int category_id);

	@Query (value ="SELECT * FROM ticket WHERE ticket_category = :category AND sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllTicketsByCategoryandSenderID(@Param("category") int category_id,@Param("sender") int sender_id);
=======
	@Query(value = "SELECT * FROM ticket where assignee_id = :assignee", nativeQuery = true)
	List<Ticket> findAllViaAssigneeTickets(@Param("assignee") int assignee);
>>>>>>> edits2
}
