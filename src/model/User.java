package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@ManagedBean
@ViewScoped
public class User {
	
	private int id;
	
	@NotNull(message = "Please enter an email. This is a required field.")
	@Email(message = "This field must be an email.")
	private String email;
	
	@NotNull(message = "Please enter a username. This is a required field.")
	@Size(min = 4, max = 15)
	private String username;

	@NotNull(message = "Please enter a password. This is a required field.")
	@Size(min = 4, max = 15)
	private String password;



	public User() {
		super();
		this.id = -1;
		this.email = "";
		this.username = "";
		this.password = "";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String email, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

}
