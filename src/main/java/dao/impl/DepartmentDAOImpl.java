package dao.impl;

import java.util.List;

import dao.DepartmentDAO;
import dao.GenericDAO;
import domain.Department;
import domain.Sport;

public class DepartmentDAOImpl extends GenericDAO<Department> implements DepartmentDAO{

	public DepartmentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Sport> findAllSports(Department d) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDepartment(Department d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<Department> getEntityType() {
		// TODO Auto-generated method stub
		return Department.class;
	}

}
