package ph.com.alliance.proj2_group1.ticket_category.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket_Category {

	@Id
	private Integer ticketcategory_id;

	private Integer default_assignee;

	private String ticketcategory_name;
	private String description;

	public Integer getTicketCategory_id() {
		return ticketcategory_id;
	}

	public Integer getDefault_Assignee() {
		return default_assignee;
	}

	public String getTicketCategory_name() {
		return ticketcategory_name;
	}

	public String getDescription() {
		return description;
	}

	public void setTicketCategory_id(Integer ticketID) {
		this.ticketcategory_id = ticketID;
	}

	public void setDefault_Assignee(Integer assignee_id) {
		this.default_assignee = assignee_id;
	}

	public void setTicketCategory_name(String ticketCategory_name) {
		this.ticketcategory_name = ticketCategory_name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
