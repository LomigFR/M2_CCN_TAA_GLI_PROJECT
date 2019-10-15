package dao;

import java.util.List;

import domain.Department;
import domain.Sport;

public class DepartmentDAOImpl extends GenericDAO<Department> implements DepartmentDAO{

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
