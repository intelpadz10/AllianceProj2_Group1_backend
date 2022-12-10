package ph.com.alliance.proj2_group1.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticket_id;
	
	@Column(name = "assignee_id")
	private Integer assignee;
	@Column(name = "sender_id")
	private Integer sender;
	@Column(name = "ticket_category")
	private Integer category;
	@Column(name = "status_id")
	private Integer status;

	private String subject;
	private String description;
	@Column(nullable = true)
	private String created_at;
	@Column(nullable = true)
	private String updated_at;
	@Column(name = "file_location", nullable = true)
	private String document_path;
	@Column(name = "deadline_at")
	private String deadline;
	public Integer getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}
	public Integer getAssignee() {
		return assignee;
	}
	public void setAssignee(Integer assignee) {
		this.assignee = assignee;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDocument_path() {
		return document_path;
	}
	public void setDocument_path(String document_path) {
		this.document_path = document_path;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}



}
