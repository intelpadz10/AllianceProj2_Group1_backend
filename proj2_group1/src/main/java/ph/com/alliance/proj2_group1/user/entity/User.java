package ph.com.alliance.proj2_group1.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "user_id")
	private Integer id;
	private Integer role_id; 
	private String user_name; 
	private String user_firstname; 
	private String user_lastname; 
	private String email;
	private String password;
	
	@Column(nullable = true)
	private String image_link;
	
	public void setUser_id(Integer user_id) {
		this.id = user_id;
	}
	
	public Integer getUser_id() {
		return id;
	}
	
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public Integer getRole_id() {
		return role_id;
	}

	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getuser_name() {
		return user_name;
	}
	
	public void setuser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getuser_firstname() {
		return user_firstname;
	}
	
	public void setuser_lastname(String user_lname) {
		this.user_lastname = user_lname;
	}
	
	public String getuser_lastname() {
		return user_lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password; 
	}
	
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getImage_link() {
		return image_link;
	}
}