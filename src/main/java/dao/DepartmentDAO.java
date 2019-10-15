package dao;

import java.util.List;

import domain.Department;
import domain.Sport;

public interface DepartmentDAO extends IDAO<Department> {
	Department save(Department d);

	List<Sport> findAllSports(Department d);
	
	String getDepartment(Department d);
}
