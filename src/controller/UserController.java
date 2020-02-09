package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import business.UserBusinessInterface;
import model.User;

@ManagedBean
@ViewScoped
public class UserController {

	@Inject
	UserBusinessInterface userService;

	public String onRegister(User user) {
		try {
			// call business service to register and store outcome in a boolean object
			boolean outcome = userService.processRegistration(user);
			// if outcome true go to success/ false unsuccessful
			if (outcome) {
				return "Login.xhtml";
			} else {
				return "Register.xhtml";
			}
			// if there is a database error catch it with custom exception
		} catch (Exception e) {
			return "error.xhtml"; //TODO rename once we get the view name
		}
	}

	public String onLogin(User user) {

		// Create session variable
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// put user on the page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);

		try {
			// login user using the businessService
			if (userService.AuthenticateUser(user) == true) {
				// set user credentials to the user
				session.setAttribute("username", user.getUsername());
				return "successfulLogin.xhtml";
			} else {
				// display unsuccessful page
				return "unsuccsessfulLogin.xhtml";
			}
			// if there is a database error catch it with custom exception
		} catch (Exception e) {
			return "error.xhtml";
		}

	}
	
	public String onLogout()
	{
		return "";
	}

}
