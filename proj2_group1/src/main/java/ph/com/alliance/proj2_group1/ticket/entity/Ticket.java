package ph.com.alliance.proj2_group1.ticket.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	private Integer ticket_id;

	private Integer assignee_id;
	private Integer sender_id;
	private Integer tracker_id;
	private Integer ticket_category;
	private Integer status;

	private String subject;
	private String description;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deadline_at;

	public Integer getTicket_id() {
		return ticket_id;
	}

	public Integer getAssignee_id() {
		return assignee_id;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public Integer getTracker_id() {
		return tracker_id;
	}

	public Integer getTicket_category() {
		return ticket_category;
	}

	public Integer getStatus() {
		return status;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public Timestamp getDeadline_at() {
		return deadline_at;
	}

	public void setTicket_id(Integer ticketID) {
		this.ticket_id = ticketID;
	}

	public void setSubject(String subject) {

		this.subject = subject;

	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAssignee_id(Integer assignee_id) {
		this.assignee_id = assignee_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public void setTracker_id(Integer tracker_id) {
		this.tracker_id = tracker_id;
	}

	public void setTicket_category(Integer ticket_category) {
		this.ticket_category = ticket_category;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void getDeadline_at(Timestamp deadline_at) {
		this.deadline_at = deadline_at;
	}

}
