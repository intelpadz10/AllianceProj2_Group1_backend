package ph.com.alliance.proj2_group1.export.service;

import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ph.com.alliance.proj2_group1.role.repository.RoleRepository;
import ph.com.alliance.proj2_group1.status.repository.StatusRepository;
import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.repository.TicketRepository;
import ph.com.alliance.proj2_group1.ticket_category.entity.Ticket_Category;
import ph.com.alliance.proj2_group1.ticket_category.repository.TicketCategoryRepository;
import ph.com.alliance.proj2_group1.user.repository.UserRepository;

@Service
public class CsvExportService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private RoleRepository rolesRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private TicketCategoryRepository categoryRepository;

	public void printAllTicketstoCSV(Writer writer) {

		List<Ticket> tickets = ticketRepository.findAll();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			csvPrinter.printRecord ("Printing All Tickets");
			csvPrinter.printRecord("TICKET ID", "TICKET SUBJECT", "TICKET DESCRIPTION", "SENDER NAME", "ASSIGNEE NAME",
					"TICKET CATEGORY", "TICKET STATUS", "DOCUMENT PATH", "DEADLINE OF TICKET");
			for (Ticket ticket : tickets) {
				csvPrinter.printRecord(ticket.getId(), ticket.getSubject(), ticket.getDescription(),
						userRepository.findById(ticket.getSender()).get().getuser_firstname() + " "
								+ userRepository.findById(ticket.getSender()).get().getuser_lastname(),
						userRepository.findById(ticket.getAssignee()).get().getuser_firstname() + " "
								+ userRepository.findById(ticket.getAssignee()).get().getuser_lastname(),
						categoryRepository.findById(ticket.getCategory()).get().getTicketCategory_name(),
						statusRepository.findById(ticket.getStatus()).get().getStatusName(), ticket.getdocument_path(),ticket.getDeadline());
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}
		public void printAllAgingTicketstoCSV(Writer writer) {

			List<Ticket> tickets = ticketRepository.findAllAgingTickets();
			try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
				csvPrinter.printRecord ("Printing All Aging Tickets");
				csvPrinter.printRecord("TICKET ID", "TICKET SUBJECT", "TICKET DESCRIPTION", "SENDER NAME", "ASSIGNEE NAME",
						"TICKET CATEGORY", "TICKET STATUS", "DOCUMENT PATH","DEADLINE OF TICKET");
				for (Ticket ticket : tickets) {
					csvPrinter.printRecord(ticket.getId(), ticket.getSubject(), ticket.getDescription(),
							userRepository.findById(ticket.getSender()).get().getuser_firstname() + " "
									+ userRepository.findById(ticket.getSender()).get().getuser_lastname(),
							userRepository.findById(ticket.getAssignee()).get().getuser_firstname() + " "
									+ userRepository.findById(ticket.getAssignee()).get().getuser_lastname(),
							categoryRepository.findById(ticket.getCategory()).get().getTicketCategory_name(),
							statusRepository.findById(ticket.getStatus()).get().getStatusName(), ticket.getdocument_path(),ticket.getDeadline());
				}
			} catch (Exception e) {
				System.out.print(e);
			}
	}
		
		public void printAllAgingTicketsbyCategorytoCSV(Writer writer, Ticket_Category tc) {
			
			List<Ticket> tickets = ticketRepository.findAllAgingTicketsByCategory(tc.getTicketCategory_id());
			try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
				csvPrinter.printRecord ("Printing All Aging Tickets according to the Category "+tc.getTicketCategory_name());
				csvPrinter.printRecord("TICKET ID", "TICKET SUBJECT", "TICKET DESCRIPTION", "SENDER NAME", "ASSIGNEE NAME",
						"TICKET CATEGORY", "TICKET STATUS", "DOCUMENT PATH","DEADLINE OF TICKET");
				for (Ticket ticket : tickets) {
					csvPrinter.printRecord(ticket.getId(), ticket.getSubject(), ticket.getDescription(),
							userRepository.findById(ticket.getSender()).get().getuser_firstname() + " "
									+ userRepository.findById(ticket.getSender()).get().getuser_lastname(),
							userRepository.findById(ticket.getAssignee()).get().getuser_firstname() + " "
									+ userRepository.findById(ticket.getAssignee()).get().getuser_lastname(),
							categoryRepository.findById(ticket.getCategory()).get().getTicketCategory_name(),
							statusRepository.findById(ticket.getStatus()).get().getStatusName(), ticket.getdocument_path(),ticket.getDeadline());
				}
			} catch (Exception e) {
				System.out.print(e);
			}
	}
}
