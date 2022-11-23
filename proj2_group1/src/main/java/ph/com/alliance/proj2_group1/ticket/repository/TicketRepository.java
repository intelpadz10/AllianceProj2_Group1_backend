package ph.com.alliance.proj2_group1.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query(value = "SELECT t FROM ticket t where t.assignee_id = :assignee", nativeQuery = true)
	List<Ticket> findAllViaAssigneeTickets(@Param("assignee") int assignee);

	/*
	 * Status Codes 1 - pending 2 - Working 3 - On Hold 4 - Completed 5 - Cancelled
	 * 6 - Deleted
	 */
	@Query(value = "SELECT t  FROM ticket t where t.status = :status", nativeQuery = true)
	List<Ticket> findAllStatusTicket(@Param("status") int status_id);

	@Query(value = "SELECT t FROM ticket t where t.status = 1 AND t.sender_id = :sender", nativeQuery = true)
	List<Ticket> findAllPendingSelectedSenderTickets(@Param("sender") int sender_id);

}
