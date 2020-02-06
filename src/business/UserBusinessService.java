package business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.User;
import models.Credentials;

public class UserBusinessService implements UserBusinessInterface {

	private List<User> users;

	public UserBusinessService() {
		users = new ArrayList<User>();
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean onRegister(User user) {
		// get the user
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		// call the dataService to create a user
		if (userDataService.create(user, -1) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean onLogin(User user) {
		// create session
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// test if User name is passed correctly
		Boolean validate = false;

		// get list of users from database
		users = userDataService.findAll();

		// validate information
		for (int i = 0; i < users.size(); i++) {
			if (user.getUsername().equals(users.get(i).getUsername())
					&& user.getPassword().equals(users.get(i).getPassword())) {
				User newUser = new User(users.get(i).getPassword() ,users.get(i).getUsername(), users.get(i).getID());
				session.setAttribute("userCred", newUser);
				validate = true;
				break;
			}
		}
		return validate;
	}

}
