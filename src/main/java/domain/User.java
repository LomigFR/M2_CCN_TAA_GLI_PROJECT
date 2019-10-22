package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User extends GenericEntity {

	private Long id;
	private String nama;
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	private String firstName;
	private String login;
	private String password;
	private String email;
	private List<Sport> listOfFavoriteSports = new ArrayList<Sport>();
	private List<Town> listOfFavoriteTowns = new ArrayList<Town>();
	private List<domain.Preference> listOfPreferences = new ArrayList<domain.Preference>();

	public User() {}
	
	public User(String name, String firstName, String email) {
		this.nama = name;
		this.firstName = firstName;
		this.email = email;
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
	@ManyToMany
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
	@ManyToMany
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
	public List<domain.Preference> getListOfPreferences() {
		return listOfPreferences;
	}

	/**
	 * @param listOfConstraints the listOfConstraints to set
	 */
	public void setListOfPreferences(List<domain.Preference> listOfPreferences) {
		this.listOfPreferences = listOfPreferences;
	}
	
	/**
	 * 
	 * @param sport
	 */
	public void addSport(Sport sport) {
		listOfFavoriteSports.add(sport);
	}
	
	/**
	 * 
	 * @param pref
	 */
	public void addPreference(Preference preference) {
		listOfPreferences.add(preference);
	}
	
	/**
	 * 
	 * @param town
	 */
	public void addTown(Town town) {
		listOfFavoriteTowns.add(town);
	}
}
