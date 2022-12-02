package ph.com.alliance.proj2_group1.role.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_id;

	@Column(name = "role_description")
	private String description;
	@Column(name = "role_initials")
	private String initials;

	public Role() {

	}

	public Role update(Role temp) {
		if (temp.getRoleDescription() != null)
			this.setRoleDescription(temp.description);
		if (temp.getRoleInitials() != null)
			this.setRoleInitials(temp.initials);
		return this;
	}

	public String getRoleDescription() {
		return description;
	}

	public String getRoleInitials() {
		return initials;
	}

	public int getRoleId() {
		return role_id;
	}

	public void setRoleDescription(String role_description) {
		this.description = role_description;
	}

	public void setRoleInitials(String role_initials) {
		this.initials = role_initials;
	}

}
