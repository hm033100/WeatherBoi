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
	String username = "";

	@NotNull(message = "Please enter a password. This is a required field.")
	@Size(min = 4, max = 15)
	String password = "";

	@NotNull(message = "Please enter an ID. This is a required field.")
	int ID;

	public User(String username, String password, int iD) {
		super();
		this.username = username;
		this.password = password;
		ID = iD;
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
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
