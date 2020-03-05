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
import dao.impl.PreferenceDAOImpl;
import dao.impl.TownDAOImpl;
import domain.Preference;
import domain.Sport;
import domain.Town;
import domain.User;
import dto.PreferenceTO;
import dto.TownTO;

@Path("/preferences")
public class PreferenceEndPoint {

	private static final Logger logger = Logger.getLogger(PreferenceEndPoint.class.getName());

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity("Ok pour les préférences !").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public Response helloWorld() {
		String helloWorld = "Ok pour Hello World PREFERENCES !";
		return Response.status(Response.Status.OK).entity(helloWorld).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getPreferenceById(@PathParam("id") Long id) {
		IDAO<Preference> prefDao = new PreferenceDAOImpl();
		Preference pref = prefDao.findById(id);
		return Response.status(Response.Status.OK).entity(createPreferenceTO(pref)).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createPreference(PreferenceTO prefTo) {
		IDAO<Preference> prefDao = new PreferenceDAOImpl();
		Preference pref = new Preference();
		pref.setName(prefTo.name);
		pref.setMaxWindStrenght(prefTo.maxWindStrenght);
		pref.setMinWindStrenght(prefTo.minWindStrenght);
		pref.setRain(prefTo.rain);
		pref.setSun(prefTo.sun);
		pref.setSwell(prefTo.swell);
		return Response.status(Response.Status.CREATED).entity(createPreferenceTO(pref)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response removePreference(@PathParam("id") Long id) {
		IDAO<Preference> prefDao = new PreferenceDAOImpl();
		prefDao.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response modifyPreference(@PathParam("id") Long id, PreferenceTO prefTo) {
		IDAO<Preference> prefDao = new PreferenceDAOImpl();
		Preference pref = prefDao.findById(id);
		if (!checkEmpty(prefTo.name)) {
			pref.setName(prefTo.name);
			pref.setMaxWindStrenght(prefTo.maxWindStrenght);
			pref.setMinWindStrenght(prefTo.minWindStrenght);
			pref.setRain(prefTo.rain);
			pref.setSun(prefTo.sun);
			pref.setSwell(prefTo.swell);
		}
		pref = prefDao.save(pref);
		return Response.status(Response.Status.OK).entity(createPreferenceTO(pref)).build();
	}

	public PreferenceTO createPreferenceTO(Preference pref) {
		PreferenceTO pto = new PreferenceTO();
		pto.id = pref.getId();
		pto.name = pref.getName();
		pto.maxWindStrenght = pref.getMaxWindStrenght();
		pto.minWindStrenght = pref.getMinWindStrenght();
		pto.rain = pref.getRain();
		pto.sun = pref.getSun();
		pto.swell = pref.getSwell();
		return pto;
	}

	public static boolean checkEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}
}
