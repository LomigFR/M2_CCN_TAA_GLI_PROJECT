package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Town extends GenericEntity {

	private Long id;
	private Department department;
	private String name;
	private List<Sport> listOfSports = new ArrayList<Sport>();
	private List<User> listOfUsers = new ArrayList<User>();

	public Town() {}


	/**
	 * @return the department
	 */
	@OneToOne /* (mappedBy = "town", cascade = CascadeType.PERSIST) */
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
	@ManyToMany/*(mappedBy="listOfTowns", cascade = CascadeType.PERSIST)*/
	public List<Sport> getListOfSports() {
		return listOfSports;
	}

	/**
	 * @param listOfSports the listOfSports to set
	 */
	public void setListOfSports(List<Sport> listOfSports) {
		this.listOfSports = listOfSports;
	}

	/**
	 * @return the listOfUsers
	 */
	@ManyToMany/*(mappedBy="listOfFavoriteTowns", cascade = CascadeType.PERSIST)*/
	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	/**
	 * @param listOfUsers the listOfUsers to set
	 */
	public void setListOfUsers(List<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
}
