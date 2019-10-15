/**
 * 
 */
package dao;

import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;

import domain.GenericEntity;
import main.EntityManagerHelper;

/**
 * @author guillaume_collet
 *
 */
public abstract class GenericDAO<T extends GenericEntity> implements IDAO<T> {

	protected EntityManager em = EntityManagerHelper.getEntityManager();

	protected abstract Class<T> getEntityType();

	public T findById(long id) {
		T entity = em.find(getEntityType(), id);
		if (entity == null) {
			throw new NotFoundException();
		}
		return entity;
	}

	public void delete(int id) {
		EntityManagerHelper.beginTransaction();
//		String query = "DELETE FROM Employee WHERE id = :id";
//		if(!em.contains(t)) {
//			t = em.merge(t);
//		}
//		em.createQuery(query, GenericEntity.class);
		T entity = findById(id);
		em.remove(entity);
		EntityManagerHelper.getEntityManager().flush();
		EntityManagerHelper.commit();
//		return t;
	}

	public T save(T t) {
		EntityManagerHelper.beginTransaction();
		if (t.getId() != 0) {
			EntityManagerHelper.getEntityManager().merge(t);
		} else {
			EntityManagerHelper.getEntityManager().persist(t);
		}
		EntityManagerHelper.commit();
		return t;
	}

	public T changeName(T t, String newName) {
		EntityManagerHelper.beginTransaction();
		if (t.getId() != 0) {
			t.setName(newName);
			EntityManagerHelper.getEntityManager().merge(t);
		} else {
			EntityManagerHelper.getEntityManager().persist(t);
		}
		EntityManagerHelper.commit();
		return t;
	}
}
