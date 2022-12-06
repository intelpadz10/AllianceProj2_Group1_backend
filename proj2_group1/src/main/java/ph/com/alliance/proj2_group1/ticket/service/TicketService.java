package ph.com.alliance.proj2_group1.ticket.service;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.repository.TicketRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {

	@Autowired
	private TicketRepository ticketJpaRepository;

	public Ticket saveTicket(Ticket ticket) {
		return ticketJpaRepository.saveAndFlush(ticket);
	}

	public Ticket updateTicket(Integer id, Ticket ticket) {
		Ticket getTicket = ticketJpaRepository.findById(id).get();
		return ticketJpaRepository.saveAndFlush(getTicket.update(ticket));
	}

	public List<Ticket> getAllTickets() {
		return ticketJpaRepository.findAll();
	}

	public List<Ticket> getAllTicketsofSender(Integer id) {
		return ticketJpaRepository.findAllTicketsBySelectedSender(id);
	}

	public Ticket getTicketbyId(Integer id) {
		return ticketJpaRepository.findById(id).get();
	}

	public List<Ticket> getTicketsViaAssignee(int assignee) {
		return ticketJpaRepository.findAllTicketsbyAssignee(assignee);
	}

	public List<Ticket> getTicketsbyStatus(int status_id) {
		return ticketJpaRepository.findAllTicketsByStatusID(status_id);
	}

	public String deleteTicket(Ticket ticket) {
		try {
			ticketJpaRepository.delete(ticket);
			return "Success Delete";
		} catch (Exception e) {
			System.out.print(e);
			return "System Error:" + e;
		}
	}

	@Override
	public List<Ticket> getAllAgingTickets() {
		// TODO Auto-generated method stub
		return ticketJpaRepository.findAllAgingTickets();
	}

	@Override
	public List<Ticket> getAllAgingTicketsBySenderID(int sender_id) {
		// TODO Auto-generated method stub
		return ticketJpaRepository.findAllAgingTicketsBySender(sender_id);
	}

	@Override
	public List<Ticket> getAllTicketsByCategory(int category) {
		// TODO Auto-generated method stub
		return ticketJpaRepository.findAllTicketsByCategory(category) ;
	}

	@Override
	public List<Ticket> getAllTicketsByCategoryAndSenderID(int category, int sender_id) {
		// TODO Auto-generated method stub
		return ticketJpaRepository.findAllTicketsByCategoryandSenderID(category, sender_id);
	}
}
