package domain;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private int id;
	private String name;
	private List<Department> listOfDepartments = new ArrayList<Department>();
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the listOfDepartments
	 */
	public List<Department> getListOfDepartments() {
		return listOfDepartments;
	}
	/**
	 * @param listOfDepartments the listOfDepartments to set
	 */
	public void setListOfDepartments(List<Department> listOfDepartments) {
		this.listOfDepartments = listOfDepartments;
	}
}
