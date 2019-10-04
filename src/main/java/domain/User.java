package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

	private int id;
	private String lastName;
	private String firstName;
	private String login;
	private String password;
	private String email;
	private List<Sport> listOfFavoriteSports = new ArrayList<Sport>();
	private List<Town> listOfFavoriteTowns = new ArrayList<Town>();
	private List<domain.Preference> listOfConstraints = new ArrayList<domain.Preference>();

	public User() {}

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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the listOfFavoriteSports
	 */
	@OneToMany
	public List<Sport> getListOfFavoriteSports() {
		return listOfFavoriteSports;
	}

	/**
	 * @param listOfFavoriteSports the listOfFavoriteSports to set
	 */
	public void setListOfFavoriteSports(List<Sport> listOfFavoriteSports) {
		this.listOfFavoriteSports = listOfFavoriteSports;
	}

	/**
	 * @return the listOfFavoriteTowns
	 */
	@OneToMany
	public List<Town> getListOfFavoriteTowns() {
		return listOfFavoriteTowns;
	}

	/**
	 * @param listOfFavoriteTowns the listOfFavoriteTowns to set
	 */
	public void setListOfFavoriteTowns(List<Town> listOfFavoriteTowns) {
		this.listOfFavoriteTowns = listOfFavoriteTowns;
	}

	/**
	 * @return the listOfConstraints
	 */
	@OneToMany
	public List<domain.Preference> getListOfConstraints() {
		return listOfConstraints;
	}

	/**
	 * @param listOfConstraints the listOfConstraints to set
	 */
	public void setListOfConstraints(List<domain.Preference> listOfConstraints) {
		this.listOfConstraints = listOfConstraints;
	}
}
