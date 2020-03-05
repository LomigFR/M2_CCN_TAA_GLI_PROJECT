package dao.impl;

import dao.GenericDAO;
import dao.RegionDAO;
import domain.Region;

public class RegionDAOImpl extends GenericDAO<Region> implements RegionDAO{

	public RegionDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Region> getEntityType() {
		// TODO Auto-generated method stub
		return Region.class;
	}

}
