package dto;

import java.util.List;

import domain.Sport;
import domain.Town;
import domain.Preference;

public class UserTO {

	public Long id;
	
	public String name;
	
	public String firstName;
	
	public String email;
	
	public List<String> listOfFavoriteSports;
	
	public List<String> listOfFavoriteTowns;
	
	public List<Preference> listOfConstraints;
}
