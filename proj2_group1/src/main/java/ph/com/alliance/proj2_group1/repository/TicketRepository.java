package ph.com.alliance.proj2_group1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.entity.Ticket;

@Repository
public class TicketRepository implements iTicketRepository{
	
	@Autowired
	private JdbcTemplate template;
	
	public Ticket findById(final int id)
	{
		try{
			final String sql = "SELECT * FROM ticket WHERE ticketID=?";
		
		final Ticket result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return result;
	
		}catch (final DataAccessException e) {
			System.out.println(e.toString());
			return new Ticket (0 , 0 , "null","null","null","null","null");
		}
	}
	
	
	public List<Ticket> findAll()
	{
		final String sql = "SELECT * FROM ticket";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		
		return result;
	}

	
	public int updateByIDAll(final Ticket ticket)
	{
		
		final String sql = "UPDATE ticket SET assignee=?,status=?,subject=?,description=?, tracker=?, classType=?  WHERE ticketID=?";
		final int result = template.update(sql, ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(), ticket.getDescription(),ticket.getTracker(),ticket.getClassType(), ticket.getTicketID());
		
		return result;
	}
	
	
	public int updateByIDAssigneeStatus(final Ticket ticket)
	{
		
		final String sql = "UPDATE ticket SET assignee=?, status=?  WHERE ticketID=?";
		final int result = template.update(sql, ticket.getAssignee(), ticket.getStatus(), ticket.getTicketID());
		
		return result;
	}
	
	
	public int updateByIDAssignee(final Ticket ticket)
	{
		final String sql = "UPDATE ticket SET assignee=?  WHERE ticketID=?";
		final int result = template.update(sql, ticket.getAssignee(),  ticket.getTicketID());
		
		return result;
	}
	
	
	public int updateByIDStatus(final Ticket ticket)
	{
		final String sql = "UPDATE ticket SET status=?  WHERE ticketID=?";
		final int result = template.update(sql, ticket.getStatus(),  ticket.getTicketID());
		
		return result;
	}
	
	
	public int createTicket(final Ticket ticket)
	{
		int result;
	try {
		
		final String sql = "INSERT INTO ticket (ticketID, assignee, status, subject, description, tracker, classType ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker(), ticket.getClassType());
		return result;
	
	}catch (DataAccessException e) {
		result = 0;
		}
		
	return result;
	}


	public int deleteByID(final int id)
	{
		try{
		final String sql = "DELETE FROM ticket WHERE ticketID=?";
		final int result = template.update(sql, id);

		return result;
		}catch (final DataAccessException e) {
			System.out.println(e.toString());
			return 0;
		}
	}

}
