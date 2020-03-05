package main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.IDAO;
import dao.impl.SportDAOImpl;
import domain.Sport;
import domain.Town;
import domain.User;
import dto.SportTO;

@Path("/sport")
public class SportEndPoint {

	private static final Logger logger = Logger.getLogger(SportEndPoint.class.getName());

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity("Ok pour les sports !").build();
	}

	@GET
	@Path("/test")
	public String helloWorld() {
		return "Ok pour Hello World SPORT !";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getSportById(@PathParam("id") Long id) {
		IDAO<Sport> sportDao = new SportDAOImpl();
		Sport sport = sportDao.findById(id);
		return Response.status(Response.Status.OK).entity(createSportTO(sport)).build();
	}

	@DELETE
	@Path("{id}")
	public Response removeSport(@PathParam("id") Long id) {
		SportDAOImpl sportDao = new SportDAOImpl();
		sportDao.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifySport(@PathParam("id") Long id, SportTO sTO) {
		IDAO<Sport> sportDao = new SportDAOImpl();
		Sport sport = sportDao.findById(id);
		if (!checkEmpty(sTO.description)) {
			sport.setDescription(sTO.description);
		}
		sportDao.save(sport);
//		sport = sportDao.save(sport);
		return Response.status(Response.Status.OK).entity(createSportTO(sport)).build();
	}

	public SportTO createSportTO(Sport sport) {
		SportTO sto = new SportTO();
		sto.id = sport.getId();
		sto.description = sport.getDescription();
		sto.name = sport.getName();
		List<String> listOfNamesOfTowns = new ArrayList<String>();
		List<String> listOfNamesOfUsers = new ArrayList<String>();

		for (Town town : sport.getListOfTowns()) {
			listOfNamesOfTowns.add(town.getName());
		}
		for (User user : sport.getListOfUsers()) {
			listOfNamesOfUsers.add(user.getName());
		}
		sto.listOfTowns = listOfNamesOfTowns;
		sto.listOfUsers = listOfNamesOfUsers;
		return sto;
	}

	public static boolean checkEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}
}
