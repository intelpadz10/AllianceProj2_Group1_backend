package ph.com.alliance.proj2_group1.user.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Integer user_id;
	
	private Integer role_id;
	
	private String user_name;
	private String user_firstname;
	private String user_lastname;
	private String email;
	@SuppressWarnings("unused")
	private String password;
	private String image_link;

	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getName() {
		return user_lastname + ", "+ user_firstname ;
	}

	public void setName(String user_lastname, String user_firstname) {
		this.user_lastname = user_lastname;
		this.user_firstname = user_firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	// no get for password ofc
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getImage_link () {
		return image_link;
	}
	
	public void setImage_link (String image_link) {
		this.image_link = image_link;
	}

}