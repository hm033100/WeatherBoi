package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	
	@NotNull(message = "Please enter a username. This is a required field.")
	@Size(min = 4, max = 15)
	private String username = "";

	@NotNull(message = "Please enter a password. This is a required field.")
	@Size(min = 4, max = 15)
	private String password = "";

	private int id;

	public User() {
		super();
		this.username = "";
		this.password = "";
		this.id = -1;
	}
	
	public User(String username, String password, int id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
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
