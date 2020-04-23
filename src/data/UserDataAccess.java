package data;

import java.sql.DriverManager;
import java.sql.ResultSet;
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
@Local(DataAccessInterface.class)
@LocalBean
public class UserDataAccess implements DataAccessInterface<User> {

	// Instantiate connection code
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3307/weatherboi";
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

		String SQLInsertUser = String.format("INSERT INTO `user` "
				+ "(`FIRST_NAME`, `LAST_NAME`, `USER_NAME`, `PASSWORD`)"
				+ " VALUES ('%s', '%s', '%s', '%s');",
				model.getFirstName(),
				model.getLastName(),
				model.getUsername(), 
				model.getPassword());

		try {
			// connect to database
			conn = DriverManager.getConnection(url, username, password);
			// create statement
			Statement stmt = conn.createStatement();
			// Run the SQL code
			int rowsAffected = stmt.executeUpdate(SQLInsertUser);
			
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
	
	/**
	 * Finds a user by their username.
	 * {@inheritDoc}
	 */
	@Override
	public User ReadTByField(User model) throws RecordNotFoundException{
		try {
			//Generate the sql
			String sql = String.format("Select `USER_ID`, `FIRST_NAME`, `LAST_NAME`, `USER_NAME`, `PASSWORD` FROM "
					+ "`weatherboi`.`user` WHERE `USER_NAME` = '%s'",
					model.getUsername());
			//Get a connection
			this.conn = DriverManager.getConnection(url, username, password);
			
			//Make the statement
			Statement stmt = this.conn.createStatement();
			
			//Execute the query
			ResultSet rs = stmt.executeQuery(sql);
			
			//Get the row affected
			rs.next();
			
			//Return the model
			return new User(
					rs.getInt("USER_ID"), 
					rs.getString("FIRST_NAME"), 
					rs.getString("LAST_NAME"), 
					rs.getString("USER_NAME"), 
					rs.getString("PASSWORD"));
		}catch(Exception e) {
			e.printStackTrace();
			throw new RecordNotFoundException();
		}finally {
			if(this.conn != null) {
				try {
					this.conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
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
