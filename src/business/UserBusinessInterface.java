package business;

import java.util.List;

import model.User;

public interface UserBusinessInterface {
	
	public List<User> getUsers();
	public Boolean onRegister(User user);
	public Boolean onLogin(User user);

}
