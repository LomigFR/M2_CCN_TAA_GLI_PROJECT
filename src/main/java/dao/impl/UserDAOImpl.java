package dao.impl;

import dao.GenericDAO;
import dao.UserDAO;
import domain.User;

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

}
