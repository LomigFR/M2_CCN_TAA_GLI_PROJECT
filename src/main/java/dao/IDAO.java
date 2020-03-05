/**
 * 
 */
package dao;

import java.util.List;

import domain.GenericEntity;
import domain.Sport;

/**
 * @author guillaume_collet
 * @param <T>
 *
 */
public interface IDAO<T> {

	T findById(Long id);

	T save(T object);

	void delete(Long id);

	List<T> findAll(GenericEntity entity);
}
