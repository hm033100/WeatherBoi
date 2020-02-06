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
	public List<T> ReadAllT(T model) throws RecordNotFoundException;
	public int UpdateT(T model) throws RecordNotUpdatedException;
	public int DeleteT(T model) throws RecordNotDeletedException;
}
