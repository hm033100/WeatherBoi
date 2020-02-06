/**
 * 
 */
package data;

import java.util.List;

import exception.RecordNotCreatedException;
import exception.RecordNotDeletedException;
import exception.RecordNotFoundException;
import exception.RecordNotUpdatedException;
import model.User;

/**
 * @author Nathan Ford
 *
 */
public class UserDataAccess implements DataAcessInterface<User> {

	/**
	 * 
	 */
	public UserDataAccess() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int CreateT(User model) throws RecordNotCreatedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User ReadT(User model) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> ReadAllT(User model) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int UpdateT(User model) throws RecordNotUpdatedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteT(User model) throws RecordNotDeletedException {
		// TODO Auto-generated method stub
		return 0;
	}

}
