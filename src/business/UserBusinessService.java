package business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.User;
import data.DataAcessInterface;
import data.UserDataAccess;
import exception.RecordNotCreatedException;
import exception.RecordNotFoundException;;

/**
 * 
 * @author Hermes Mimini
 *
 */

@Stateless
@Local(UserBusinessInterface.class)
@LocalBean
public class UserBusinessService implements UserBusinessInterface {

	private List<User> users;
	
	@Inject 
	UserDataAccess das;

	/**
	 * @see UserBusinessInterface
	 */
	public UserBusinessService() {
		users = new ArrayList<User>();
	}

	/**
	 * @see UserBusinessInterface
	 */
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @throws RecordNotCreatedException 
	 * @see UserBusinessInterface
	 */
	@Override
	public Boolean processRegistration(User user) throws RecordNotCreatedException {
		//Hash the user password
		user.setPassword(hashPassword(user.getPassword()));
		
		//Send user to database
		int dataReturned = 0; //TODO Check if there is more than 1 user -Hermes
		
			das.CreateT(user);
		
		//return true if effected rows is one
		if(dataReturned == 1) {
			return true;
		}
		//return false otherwise
		else {
			return false;
		}
	}

	@Override
	public Boolean AuthenticateUser(User user) throws Exception {
		//Get user from the database
		User dbUser = das.ReadTByField(user);
		
		//Hash logging in users credentials
		user.setPassword(hashPassword(user.getPassword()));
		
		//Compare and return result
		return dbUser.getPassword().equals(user.getPassword()) ? true : false;

	}
	
	public String hashPassword(String pass) {
    	try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pass.getBytes());
			
			byte byteData[] = md.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<byteData.length; i++)
			{
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }

}
