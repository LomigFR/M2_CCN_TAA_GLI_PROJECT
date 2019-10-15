package dao.impl;

import dao.GenericDAO;
import dao.TownDAO;
import domain.Town;

public class TownDAOImpl extends GenericDAO<Town> implements TownDAO{

	public TownDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Town> getEntityType() {
		// TODO Auto-generated method stub
		return Town.class;
	}

}
