package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Preference extends GenericEntity{

	private Long id;
	private String name;
	private int swell;
	private int minWindStrenght;
	private int maxWindStrenght;
	private Boolean rain;
	private Boolean sun;
	private User user;

	public Preference() {}

	
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
	 * @return the swell
	 */
	public int getSwell() {
		return swell;
	}

	/**
	 * @param swell the swell to set
	 */
	public void setSwell(int swell) {
		this.swell = swell;
	}

	/**
	 * @return the minWindStrenght
	 */
	public int getMinWindStrenght() {
		return minWindStrenght;
	}

	/**
	 * @param minWindStrenght the minWindStrenght to set
	 */
	public void setMinWindStrenght(int minWindStrenght) {
		this.minWindStrenght = minWindStrenght;
	}

	/**
	 * @return the maxWindStrenght
	 */
	public int getMaxWindStrenght() {
		return maxWindStrenght;
	}

	/**
	 * @param maxWindStrenght the maxWindStrenght to set
	 */
	public void setMaxWindStrenght(int maxWindStrenght) {
		this.maxWindStrenght = maxWindStrenght;
	}

	/**
	 * @return the rain
	 */
	public Boolean getRain() {
		return rain;
	}

	/**
	 * @param rain the rain to set
	 */
	public void setRain(Boolean rain) {
		this.rain = rain;
	}

	/**
	 * @return the sun
	 */
	public Boolean getSun() {
		return sun;
	}

	/**
	 * @param sun the sun to set
	 */
	public void setSun(Boolean sun) {
		this.sun = sun;
	}

	/**
	 * @return the user
	 */
	@JsonIgnore
	@OneToOne
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
