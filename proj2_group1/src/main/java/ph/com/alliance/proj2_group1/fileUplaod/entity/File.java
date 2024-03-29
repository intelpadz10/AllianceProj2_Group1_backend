package ph.com.alliance.proj2_group1.fileUplaod.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int file_id;
	private int ticket_id;
	private String path;
	
	public void setFileID(int file_id) {
		this.file_id = file_id;
	}
	
	public int getFileID() {
		return file_id;
	}
	
	public void setTicketID(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	
	public int getTicketID() {
		return ticket_id;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
