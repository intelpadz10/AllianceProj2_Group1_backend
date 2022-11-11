package ph.com.alliance.proj2_group1.ticket.service;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService{

	@Autowired
	private TicketRepository ticketJpaRepository;

	public Ticket saveTicket(Ticket ticket) {
		return ticketJpaRepository.saveAndFlush(ticket);
	}

}
