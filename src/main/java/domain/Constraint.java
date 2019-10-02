package domain;

public class Constraint {

	private String name;
	private int swell;
	private int minWindStrenght;
	private int maxWindStrenght;
	
	
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
	
}
