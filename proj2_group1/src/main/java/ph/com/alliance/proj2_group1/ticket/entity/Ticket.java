package ph.com.alliance.proj2_group1.ticket.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;  
import java.time.LocalDateTime;  

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticket_id;
	private Integer assignee_id;
	private Integer sender_id;
	private Integer ticket_category;
	private Integer status_id;
	private String subject;
	private String description;
	@Column(nullable = true)
	private String created_at;
	@Column(nullable = true)
	private String updated_at;
	@Column (nullable = true)
	private String document_path;
	//this one is required 
	private String deadline_at;
	
	public Ticket update (Ticket temp) {
		if (temp.getAssignee_id() != null )
			this.setAssignee_id(temp.assignee_id);
		if (temp.getStatus_id() != null)
			this.setStatus_id (temp.status_id);
		if (temp.getSubject() != null)
			this.setSubject(temp.subject);
		if (temp.getDescription() != null)
			this.setDescription(temp.description);
		if (temp.getDocument_path() != null)
			this.setDocument_Path(temp.document_path);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
		this.setUpdated_at(timestamp.toString());
		return this;
	}

	public Integer getTicket_id() {
		return ticket_id;
	}

	public Integer getAssignee_id() {
		return assignee_id;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public Integer getTicket_category() {
		return ticket_category;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getDeadline_at() {
		return deadline_at;
	}
	
	public String getDocument_path() {
		return document_path;
	}


	public String getUpdated_at() {
		return updated_at;
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

	public void setTicket_category(Integer ticket_category) {
		this.ticket_category = ticket_category;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public void setStatus_id(Integer status) {
		this.status_id = status;
	}

	public void setDeadline_at(String deadline_at) {
		this.deadline_at = deadline_at;
	}
	public void setDocument_Path(String document_path) {
		this.document_path = document_path;
	}


}
