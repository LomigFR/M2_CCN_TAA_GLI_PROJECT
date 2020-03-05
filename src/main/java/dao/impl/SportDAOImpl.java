package dao.impl;

import dao.GenericDAO;
import dao.SportDAO;
import domain.Sport;

public class SportDAOImpl extends GenericDAO<Sport> implements SportDAO {

	public SportDAOImpl() {
		super();
	}

	@Override
	protected Class<Sport> getEntityType() {
		return Sport.class;
	}
}
