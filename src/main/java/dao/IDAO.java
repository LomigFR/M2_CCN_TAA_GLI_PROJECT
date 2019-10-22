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

	T findById(Long id);

	T save(T object);

	void delete(Long id);
}
