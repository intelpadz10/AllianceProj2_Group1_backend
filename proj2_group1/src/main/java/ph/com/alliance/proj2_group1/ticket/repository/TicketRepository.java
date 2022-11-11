package ph.com.alliance.proj2_group1.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
