package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;

import domain.GenericEntity;
import main.EntityManagerHelper;

/**
 * @author guillaume_collet
 *
 */
public abstract class GenericDAO<T extends GenericEntity> implements IDAO<T> {

	GenericEntity entity;
	
	protected EntityManager em = EntityManagerHelper.getEntityManager();

	protected abstract Class<T> getEntityType();

	public T findById(Long id) {
		T entity = em.find(getEntityType(), id);
		if (entity == null) {
			throw new NotFoundException();
		}
		return entity;
	}

	public void delete(Long id) {
		EntityManagerHelper.beginTransaction();
		T entity = findById(id);
		em.remove(entity);
		EntityManagerHelper.getEntityManager().flush();
		EntityManagerHelper.commit();
	}

	public T save(T t) {
		EntityManagerHelper.beginTransaction();
		if (t.getId() != 0) {
			//em.merge(t);
			EntityManagerHelper.getEntityManager().merge(t);
		} else {
			//em.persist(t);
			EntityManagerHelper.getEntityManager().persist(t);
		}
		EntityManagerHelper.commit();
		return t;
	}
	
	public List<T> findAll() {
		String s = "select u from "+ entity.getClass()+" as u";
		return EntityManagerHelper.getEntityManager().createQuery(s, getEntityType())
				.getResultList();
	}
}
