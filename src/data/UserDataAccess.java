package data;

import java.sql.DriverManager;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RecordNotCreatedException;
import exception.RecordNotDeletedException;
import exception.RecordNotFoundException;
import exception.RecordNotUpdatedException;
import model.User;

/**
 * @author Nathan Ford
 *
 */
@Stateless
@Local(DataAcessInterface.class)
@LocalBean
public class UserDataAccess implements DataAcessInterface<User> {

	// Instantiate connection code
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/weatherboi";
	String username = "root";
	String password = "root";

	/**
	 * 
	 */
	public UserDataAccess() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int CreateT(User model) throws RecordNotCreatedException {

		String SQLInsertUser = String
				.format("INSERT INTO `user` (`USER_ID`, `FIRST_NAME`, `LAST_NAME`, `USER_NAME`, `PASSWORD`)"
						+ " VALUES (NULL, NULL, NULL, '%s', '%s');", model.getUsername(), model.getPassword());
		int rowsAffected = -1;

		try {
			// connect to database
			conn = DriverManager.getConnection(url, username, password);
			// create statement
			Statement stmt = conn.createStatement();
			// Run the SQL code
			rowsAffected = stmt.executeUpdate(SQLInsertUser);
			return rowsAffected;
		} catch (SQLException e) {
			// print stack trace
			e.printStackTrace();
			// throw custom exception
			throw new RecordNotCreatedException();
		} finally {
			if (conn != null) {
				try {
					// close connection
					conn.close();
				} catch (SQLException e) {
					// print stack trace
					e.printStackTrace();
				}
			}
		}
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
