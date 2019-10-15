package dao.impl;

import dao.GenericDAO;
import dao.SportDAO;
import domain.Sport;

public class SportDAOImpl extends GenericDAO<Sport> implements SportDAO {

	public SportDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Sport> getEntityType() {
		// TODO Auto-generated method stub
		return Sport.class;
	}
}
