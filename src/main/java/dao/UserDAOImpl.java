package dao;

import domain.User;

public class UserDAOImpl extends GenericDAO<User> implements UserDAO{

	@Override
	protected Class<User> getEntityType() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
