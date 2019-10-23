package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import dao.GenericDAO;
import dao.UserDAO;
import domain.User;
import main.EntityManagerHelper;

public class UserDAOImpl extends GenericDAO<User> implements UserDAO{

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<User> getEntityType() {
		// TODO Auto-generated method stub
		return User.class;
	}
	
	public User save(User user) {
		EntityManagerHelper.beginTransaction();
		if (user.getName() != null) {
			EntityManagerHelper.getEntityManager().merge(user);
		} else {
			EntityManagerHelper.getEntityManager().persist(user);
		}
		EntityManagerHelper.commit();
		return user;
	}
	
	public List<User> findAll() {
		//String s = "select u from "+ entity.getClass()+" as u";
		String s = "select u from User as u";
		return EntityManagerHelper.getEntityManager().createQuery(s, getEntityType())
				.getResultList();
	}

}
