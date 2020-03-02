package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import business.UserBusinessService;
import model.User;

@ManagedBean
@ViewScoped
public class UserController {

	@Inject
	UserBusinessService userService;

	public String onRegister(User user) {
		try {
			// if outcome true go to success/ false unsuccessful
			if (userService.processRegistration(user)) {
				return "Login.xhtml";
			} else {
				return "Register.xhtml";
			}
			// if there is a database error catch it with custom exception
		} catch (Exception e) {
			e.printStackTrace();
			return "Register.xhtml"; //TODO make error page
		}
	}

	public String onLogin(User user) {
		try {
			// login user using the businessService
			if (userService.AuthenticateUser(user)) {
				// set user credentials to the user
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
				return "ColumnChart.xhtml";
			} else {
				// display unsuccessful page
				return "Login.xhtml";
			}
			// if there is a database error catch it with custom exception
		} catch (Exception e) {
			e.printStackTrace();
			return "Login.xhtml";	//TODO make exceptions page
		}

	}
	
	public String onLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "Login.xhtml";
	}

}
