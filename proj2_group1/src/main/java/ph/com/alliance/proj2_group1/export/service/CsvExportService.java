package ph.com.alliance.proj2_group1.export.service;

import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.repository.TicketRepository;
import ph.com.alliance.proj2_group1.user.entity.User;
import ph.com.alliance.proj2_group1.user.repository.UserRepository;

@Service
public class CsvExportService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private UserRepository userRepository;

	public void writeEmployeesToCsv(Writer writer) {

		List <User> users = userRepository.findAll();
		List<Ticket> tickets = ticketRepository.findAll();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for (Ticket ticket : tickets) {
				csvPrinter.printRecord(ticket.getId(), ticket.getSubject(),ticket.getDescription(), ticket.getAssignee(), ticket.getAssignee(),
						ticket.getCategory());
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
