package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {

	private Region region;
	private int id;
	private String name;
	private List<Town> listOfTowns = new ArrayList<Town>();

	public Department() {}

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
	@OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
	public List<Town> getListOfTowns() {
		return listOfTowns;
	}

	/**
	 * @param listOfTowns the listOfTowns to set
	 */
	public void setListOfTowns(List<Town> listOfTowns) {
		this.listOfTowns = listOfTowns;
	}

	/**
	 * @return the region
	 */
	@OneToOne
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
}
