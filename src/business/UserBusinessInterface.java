package business;

import java.util.List;

import model.User;

/**
 * 
 * @author Hermes Mimini
 *
 */
public interface UserBusinessInterface {
	
	/**
	 * Gets a list of all the users of the application
	 * @return List<User>
	 */
	public List<User> getUsers();	//TODO possibly wont impliment maybe delete or simply throw exception
	
	/**
	 * Hash password and send it to the database for saving
	 * @param user
	 * @return Boolean
	 */
	public Boolean processRegistration(User user) throws Exception;
	
	/**
	 * Get user from the database and authenticate login
	 * @param user
	 * @return Boolean
	 */
	public Boolean AuthenticateUser(User user) throws Exception;

}
