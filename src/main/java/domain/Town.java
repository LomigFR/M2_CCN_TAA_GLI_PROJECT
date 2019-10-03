package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@javax.persistence.Entity
public class Town {

	private int id;
	private Department department;
	private String name;
	private List<Sport> listOfSports = new ArrayList<Sport>();

	public Town() {
		super();
	}
	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue
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
	 * @return the department
	 */
//	@OneToOne /*(mappedBy = "town", cascade = CascadeType.PERSIST)*/
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
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
	 * @return the listOfSports
	 */
	public List<Sport> getListOfSports() {
		return listOfSports;
	}
	/**
	 * @param listOfSports the listOfSports to set
	 */
	public void setListOfSports(List<Sport> listOfSports) {
		this.listOfSports = listOfSports;
	}
	
}
