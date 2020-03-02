package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	
	private int id;
	
	@NotNull(message = "Please enter an First Name. This is a required field.")
	private String firstName;
	
	@NotNull(message = "Please enter your Last Name. This is a required field.")
	private String lastName;
	
	@NotNull(message = "Please enter a username. This is a required field.")
	@Size(min = 4, max = 15)
	private String username;

	@NotNull(message = "Please enter a password. This is a required field.")
	@Size(min = 4, max = 15)
	private String password;



	public User() {
		super();
		this.id = 0;
		this.username = "";
		this.password = "";
	}
	
	public User(int id, String firstName, String lastName, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
}
