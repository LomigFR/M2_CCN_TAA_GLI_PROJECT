package dto;

import java.util.ArrayList;
import java.util.List;

import domain.Region;

public class DepartmentTO {

	public Long id;
	public Region region;
	public String name;
	public List<String> listOfTowns = new ArrayList<String>();
}
