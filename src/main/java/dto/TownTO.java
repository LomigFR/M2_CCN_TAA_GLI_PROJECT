package dto;

import java.util.ArrayList;
import java.util.List;

import domain.Department;

public class TownTO {
	
	public Long id;
	public Department department;
	public String name;
	public List<String> listOfSports = new ArrayList<String>();
	public List<String> listOfUsers = new ArrayList<String>();
}
