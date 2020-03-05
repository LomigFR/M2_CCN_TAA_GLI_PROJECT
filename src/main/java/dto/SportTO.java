package dto;

import java.util.ArrayList;
import java.util.List;

import domain.Town;
import domain.User;

public class SportTO {

	public Long id;
	public String name;
	public String description;
	public List<String> listOfTowns = new ArrayList<String>();
	public List<String> listOfUsers = new ArrayList<String>();
}
