package dto;

import java.util.List;

import domain.Sport;
import domain.Town;
import domain.Preference;

public class UserTO {

	public int id;
	
	public String name;
	
	public String firstName;
	
	public String email;
	
	public List<Sport> listOfFavoriteSports;
	
	public List<Town> listOfFavoriteTowns;
	
	public List<Preference> listOfConstraints;
}
