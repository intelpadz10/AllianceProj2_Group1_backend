package ph.com.alliance.proj2_group1.ticket.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;
//import ph.com.alliance.proj2_group1.repository.iTicketRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}

