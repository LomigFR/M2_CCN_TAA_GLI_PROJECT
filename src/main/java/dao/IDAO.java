/**
 * 
 */
package dao;

/**
 * @author guillaume_collet
 * @param <T>
 *
 */
public interface IDAO<T> {

	T findById(long id);

	T save(T object);

	void delete(int id);
}
