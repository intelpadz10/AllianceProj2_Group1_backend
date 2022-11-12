package ph.com.alliance.proj2_group1.ticket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	private Integer ticket_id;
	private String assignee;
	private String status;
	private String subject;
	private String description;
	private String tracker;

	public Integer getTicketID() {
		return ticket_id;
	}

	public void setTicketID(Integer ticketID) {
		this.ticket_id = ticketID;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTracker() {
		return tracker;
	}

	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
	/* ORIGINAL CODE
	 private int ticketID;
	private int assignee;
	private String status;
	private String subject;
	private String description;
	private String tracker;
	private String classType;
	
	public Ticket()
	{
	}
	
	public Ticket(
			final int ticketID, 
			final int assignee, 
			final String status,
			final String subject,
			final String description,
			final String tracker,
			final String classType)
	{
		this.ticketID = ticketID;
		this.assignee = assignee;
		this.status = status;
		this.subject = subject;
		this.description = description;
		this.tracker = tracker;
		this.classType = classType;
	}
	
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public int getAssignee() {
		return assignee;
	}
	public void setAssignee(int assignee) {
		this.assignee = assignee;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTracker() {
		return tracker;
	}
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
	
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	 */

}
