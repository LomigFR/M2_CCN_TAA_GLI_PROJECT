package dto;

import java.util.ArrayList;
import java.util.List;
import domain.Department;

public class RegionTO {

	public Long id;
	public String name;
	public List<String> listOfDepartments = new ArrayList<String>();
}
