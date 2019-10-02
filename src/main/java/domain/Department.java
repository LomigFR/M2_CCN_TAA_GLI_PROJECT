package domain;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private int id;
	private String name;
	private List<Town> listOfTowns = new ArrayList<Town>();

	
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
	 * @return the listOfTowns
	 */
	public List<Town> getListOfTowns() {
		return listOfTowns;
	}
	/**
	 * @param listOfTowns the listOfTowns to set
	 */
	public void setListOfTowns(List<Town> listOfTowns) {
		this.listOfTowns = listOfTowns;
	}
}
