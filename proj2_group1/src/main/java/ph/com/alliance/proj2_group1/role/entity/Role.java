package ph.com.alliance.proj2_group1.role.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
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
		if (temp.getdescription() != null)
			this.setdescription(temp.description);
		if (temp.getinitials() != null)
			this.setinitials(temp.initials);
		return this;
	}

	public String getdescription() {
		return description;
	}

	public String getinitials() {
		return initials;
	}

	public Integer getId() {
		return role_id;
	}
	public void setId(Integer id) {
		this. role_id = id;
	}

	public void setrole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}

	public void setinitials(String initials) {
		this.initials = initials;
	}

}
