package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
public class Sport {

	private int id;
	private Town town;
	private String name;
	private String description;

	
	public Sport() {
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
	 * @return the town
	 */
	public Town getTown() {
		return town;
	}
	/**
	 * @param town the town to set
	 */
	public void setTown(Town town) {
		this.town = town;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
