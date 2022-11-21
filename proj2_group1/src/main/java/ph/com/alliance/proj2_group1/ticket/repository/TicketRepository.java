package ph.com.alliance.proj2_group1.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query(value = "SELECT t FROM ticket t where t.assignee_id = :assignee",nativeQuery = true)
	List<Ticket> findAllViaAssigneeTickets(@Param("assignee") int assignee);

	
// Status Ticket Check
	@Query(value = "SELECT t  FROM ticket t where t.status = :statuskey",nativeQuery = true)
	List<Ticket> findAllStatusTicket(@Param ("statuskey") int status_id);
		//1 - pending
		//2 - Working
		//3 - On Hold
		//4 - Completed
		//5 - Cancelled
		//6 - Deleted
	
		//	@Query("SELECT t FROM ticket t where t.status = 1")
		//	List<Ticket> findAllPendingTickets();
		//
		//	@Query("SELECT t FROM ticket t where t.status = 2")
		//	List<Ticket> findAllWorkingTickets();
		//
		//	@Query("SELECT t FROM ticket t where t.status = 3")
		//	List<Ticket> findAllOnHoldTickets();
		//
		//	@Query("SELECT t FROM ticket t where t.status = 4")
		//	List<Ticket> findAllCompletedTickets();
		//
		//	@Query("SELECT t FROM ticket t where t.status = 5")
		//	List<Ticket> findAllCancelledTickets();
		//
		//	@Query("SELECT t FROM ticket t where t.status = 6")
		//	List<Ticket> findAllDeletedTickets();

	// Custom Queries
	@Query(value = "SELECT t FROM ticket t where t.status = 1 AND t.sender_id = :sender",nativeQuery = true)
	List<Ticket> findAllPendingSelectedSenderTickets();

	@Modifying
	@Query(value ="UPDATE ticket t set t.status = :status where ticket_id = :ticket_id",nativeQuery = true)
	Ticket changeTicketStatus(@Param("status") int status_code, @Param("ticket_id") int ticket_id);

	@Modifying
	@Query(value ="UPDATE ticket t set t.updated_at = CURRENT_TIMESTAMP where ticket_id = :ticket_id",nativeQuery = true)
	Ticket changeUpdateDate(@Param("ticket_id") int ticket_id);

	@Modifying
	@Query(value ="UPDATE ticket t set t.deadline_at = :deadline_at where ticket_id = :ticket_id",nativeQuery = true)
	Ticket changeDeadlineDate(@Param("deadline_at") String deadline_at_timestamp, @Param("ticket_id") int ticket_id);

	@Modifying
	@Query(value ="UPDATE ticket t set t.document_path = :path where ticket_id = :ticket_id",nativeQuery = true)
	Ticket changeDocumentPath(@Param("path") String document_path, @Param("ticket_id") int ticket_id);
}
