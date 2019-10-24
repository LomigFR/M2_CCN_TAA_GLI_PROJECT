package dao.impl;

import dao.GenericDAO;
import dao.TownDAO;
import domain.Town;

public class TownDAOImpl extends GenericDAO<Town> implements TownDAO {

	public TownDAOImpl() {
		super();
	}

	@Override
	protected Class<Town> getEntityType() {
		return Town.class;
	}
}
