package dao.impl;

import dao.GenericDAO;
import dao.PreferenceDAO;
import domain.Preference;

public class PreferenceDAOImpl extends GenericDAO<Preference> implements PreferenceDAO{

	public PreferenceDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Class<Preference> getEntityType() {
		// TODO Auto-generated method stub
		return Preference.class;
	}

}
