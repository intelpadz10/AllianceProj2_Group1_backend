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
	@Column(name = "ticket_id")
	private Integer id;
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
	@Column (nullable = true)
	private String created_at;
	@Column (nullable = true )
	private String updated_at;
	@Column(name = "document_path", nullable = true)
	private String file_upload;
	@Column(name = "deadline_at")
	private String deadline;

	public Ticket() {
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
		this.setUpdated_at(timestamp.toString());
		this.setCreated_at(timestamp.toString());
		if (this.file_upload == "null") {
			this.file_upload = "no_data";
		}
	};

	public Ticket update(Ticket temp) {
		if (temp.getAssignee() != null)
			this.setAssignee(temp.assignee);
		if (temp.getStatus() != null)
			this.setStatus(temp.status);
		if (temp.getSubject() != null)
			this.setSubject(temp.subject);
		if (temp.getDescription() != null)
			this.setDescription(temp.description);
		if (temp.getDocument_path() != null)
			this.setDocument_Path(temp.file_upload);

		// an automatic system for the app to update the ticket's update status
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
		this.setUpdated_at(timestamp.toString());
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAssignee() {
		return assignee;
	}

	public Integer getSender() {
		return sender;
	}

	public Integer getCategory() {
		return category;
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

	public String getCreated_at() {
		return created_at;
	}

	public String getDeadline() {
		return deadline;
	}

	public String getDocument_path() {
		return file_upload;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAssignee(Integer assignee) {
		this.assignee = assignee;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setSubject(String subject) {

		this.subject = subject;

	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public void setDeadline_at(String deadline_at) {
		this.deadline = deadline_at;
	}

	public void setDocument_Path(String file_upload_path) {
		this.file_upload = file_upload_path;
	}

}
