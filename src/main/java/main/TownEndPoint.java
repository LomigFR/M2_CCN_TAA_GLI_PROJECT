package main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.IDAO;
import dao.impl.TownDAOImpl;
import domain.Sport;
import domain.Town;
import domain.User;
import dto.TownTO;

@Path("/towns")
public class TownEndPoint {

	private static final Logger logger = Logger.getLogger(TownEndPoint.class.getName());

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity("Ok pour les villes !").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("test")
	public Response helloWorld() {
		String helloWorld = "Ok pour Hello World TOWN !";
		return Response.status(Response.Status.OK).entity(helloWorld).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getTownById(@PathParam("id") Long id) {
		IDAO<Town> townDao = new TownDAOImpl();
		Town town = townDao.findById(id);
		return Response.status(Response.Status.OK).entity(createTownTO(town)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/dept")
	public Response getDepartmentOfTown(@PathParam("id") Long id) {
		IDAO<Town> townDao = new TownDAOImpl();
		Town town = townDao.findById(id);
		return Response.status(Response.Status.OK).entity(createTownTO(town).department.getName()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/sports")
	public Response getSportsOfTown(@PathParam("id") Long id) {
		IDAO<Town> townDao = new TownDAOImpl();
		Town town = townDao.findById(id);
		return Response.status(Response.Status.OK).entity(displayListOfSports(createTownTO(town))).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/users")
	public Response getUsersOfTown(@PathParam("id") Long id) {
		IDAO<Town> townDao = new TownDAOImpl();
		Town town = townDao.findById(id);
		return Response.status(Response.Status.OK).entity(displayListOfUsers(createTownTO(town))).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public /*Response*/ List<TownTO> getAllTowns() {
		IDAO<Town> townDao = new TownDAOImpl();
		List<TownTO> listOfTowns = new ArrayList<TownTO>();
		
		/**
		 * TODO : exploitation de la généricité à peaufiner !
		 */
		for(Town town : townDao.findAll(new Town())) {
			listOfTowns.add(createTownTO(town));
		}
		return listOfTowns;
//		return Response.status(Response.Status.OK).entity(listOfTowns).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createTown(TownTO townTo) {
		IDAO<Town> townDao = new TownDAOImpl();
		Town town = new Town();
		/**
		 * Autre possibilité : constructeur avec paramètres
		 */
		town.setName(townTo.name);
		town.setDepartment(townTo.department);
		townDao.save(town);
		return Response.status(Response.Status.CREATED).entity(createTownTO(town)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response removeTown(@PathParam("id") Long id) {
		IDAO<Town> townDao = new TownDAOImpl();
		townDao.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response modifyTown(@PathParam("id") Long id, TownTO townTo) {
		IDAO<Town> townDao = new TownDAOImpl();
		Town town = townDao.findById(id);
		if (!checkEmpty(townTo.name)) {
			town.setName(townTo.name);
		}
		townDao.save(town);
//		town = townDao.save(town);
		return Response.status(Response.Status.OK).entity(createTownTO(town)).build();
	}

	public TownTO createTownTO(Town town) {
		TownTO tto = new TownTO();
		tto.id = town.getId();
		tto.department = town.getDepartment();
		tto.name = town.getName();
		List<String> listOfNamesOfSports = new ArrayList<String>();
		List<String> listOfNamesOfUsers = new ArrayList<String>();
		for (Sport sport : town.getListOfSports()) {
			listOfNamesOfSports.add(sport.getName());
		}
		for (User user : town.getListOfUsers()) {
			listOfNamesOfUsers.add(user.getName());
		}
		tto.listOfSports = listOfNamesOfSports;
		tto.listOfUsers = listOfNamesOfUsers;
		return tto;
	}

	public static boolean checkEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

	public String displayListOfSports(TownTO townTo) {
		String listOfSports = "";
		for (String sport : townTo.listOfSports) {
			listOfSports += (sport + "\n");
		}
		return listOfSports;
	}

	private String displayListOfUsers(TownTO townTO) {
		String listOfUsers = "";
		for (String user : townTO.listOfUsers) {
			listOfUsers += (user + "\n");
		}
		return listOfUsers;
	}
}
