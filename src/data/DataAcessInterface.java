package data;

import java.util.List;

import exception.RecordNotCreatedException;
import exception.RecordNotDeletedException;
import exception.RecordNotFoundException;
import exception.RecordNotUpdatedException;

/**
 * 
 * @author Nathan Ford
 *
 * @param <T>
 */
public interface DataAcessInterface<T> {

	/**
	 * Store model in the database
	 * @param model
	 * @return
	 * @throws RecordNotCreatedException
	 */
	public int CreateT(T model) throws RecordNotCreatedException;
	
	/**
	 * Read model from the database
	 * @param model
	 * @return
	 * @throws RecordNotFoundException
	 */
	public T ReadT(T model) throws RecordNotFoundException;
	
	/**
	 * Reads in a model from a specified field. Check overridden comments.
	 * @param model
	 * @return
	 * @throws RecordNotFoundException
	 */
	public T ReadTByField(T model) throws RecordNotFoundException;
	
	/**
	 * Read all rows in from the database
	 * @param model
	 * @return
	 * @throws RecordNotFoundException
	 */
	public List<T> ReadAllT(T model) throws RecordNotFoundException;
	
	/**
	 * Updates a model in the database
	 * @param model
	 * @return
	 * @throws RecordNotUpdatedException
	 */
	public int UpdateT(T model) throws RecordNotUpdatedException;
	
	/**
	 * Deletes a model from the database. Unless overrided, will delete from the id
	 * parameter.
	 * @param model
	 * @return
	 * @throws RecordNotDeletedException
	 */
	public int DeleteT(T model) throws RecordNotDeletedException;
}
