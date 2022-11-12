package ph.com.alliance.proj2_group1.ticket_category.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketCategory {

	@Id
	private Integer ticketCategory_id;

	private Integer default_assignee;

	private String ticketCategory_name;
	private String description;

	public Integer getTicketCategory_id() {
		return ticketCategory_id;
	}

	public Integer getDefault_Assignee() {
		return default_assignee;
	}

	public String getTicketCategory_name() {
		return ticketCategory_name;
	}

	public String getDescription() {
		return description;
	}

	public void setTicketCategory_id(Integer ticketID) {
		this.ticketCategory_id = ticketID;
	}

	public void setDefault_Assignee(Integer assignee_id) {
		this.default_assignee = assignee_id;
	}

	public void setTicketCategory_name(String ticketCategory_name) {
		this.ticketCategory_name = ticketCategory_name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
