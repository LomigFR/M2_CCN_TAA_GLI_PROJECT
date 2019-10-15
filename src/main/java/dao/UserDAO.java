package dao;

import domain.User;

public interface UserDAO extends IDAO<User>{
	User save (User u);
	
	
}
