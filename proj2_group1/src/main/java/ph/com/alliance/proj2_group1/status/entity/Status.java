package ph.com.alliance.proj2_group1.status.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	private Integer status_id;

	private String status_name;
	private String description;

	public Integer getStatusId() {
		return status_id;
	}

	public String getStatusName() {
		return status_name;
	}

	public String getDescription() {
		return description;
	}

}
