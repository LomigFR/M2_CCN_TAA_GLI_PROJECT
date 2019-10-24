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

import dao.impl.UserDAOImpl;
import domain.Sport;
import domain.Town;
import domain.User;
import dto.UserTO;


@Path("/users")
public class StatusEndpoint {

    private static final Logger logger = Logger.getLogger(StatusEndpoint.class.getName());

//    @GET
//    public Response getStatus() {
//
//        return Response.status(Response.Status.OK).entity("c'est bon yo!").build();
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserTO>  getAllUsers(){
    	UserDAOImpl userdao = new UserDAOImpl();
    	List<UserTO> users = new ArrayList<UserTO>();
    	for(User u : userdao.findAll()) {
    		users.add(createUserTO(u));
    	}
    	return users;
    }
    
    @GET
    @Path("/test")
    public String helloWorld() {
        return "ca aussi ca marche!";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
   // public Response getEmployeeById() {
    public Response getUserById(@PathParam("id") Long eId) {
    	UserDAOImpl userdao = new UserDAOImpl();
    	User u = userdao.findById(eId);
    	
    	return Response.status(Response.Status.OK).entity(createUserTO(u)).build();
    	
		/*DaoEmployee daoEmp = new DaoEmployee();
		DaoDepartment daoDep = new DaoDepartment();
		
		return daoEmp.findById(1L).getName();*/
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserTO uTO) {
    	User us = new User(uTO.name, uTO.firstName, uTO.email);
    	UserDAOImpl userdao = new UserDAOImpl();
    	us = userdao.save((User) us);
    	return Response.status(Response.Status.CREATED).entity(createUserTO(us)).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response removeUser(@PathParam("id") Long eId) {
    	UserDAOImpl userdao = new UserDAOImpl();
    	userdao.delete(eId);
    	return Response.noContent().build();
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyUser(@PathParam("id") Long eId, UserTO uTO) {
    	UserDAOImpl userdao = new UserDAOImpl();
    	User us = userdao.findById(eId);
    	if(!checkEmpty(uTO.name)) {
    		us.setNama(uTO.name);
    	}
    	us = userdao.save(us);
    	return Response.status(Response.Status.OK).entity(createUserTO(us)).build();
    }

    /*@GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
    	Person p = new Person();
    	p.setName("test");
    	p.setFirstName("t");
        return p;
    }

    @POST
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Person p) {
    	System.err.println(p.getName());
    }*/
    
    public UserTO createUserTO(User us) {
    	UserTO dto = new UserTO();
    	dto.id = us.getId();
    	dto.name = us.getNama();
    	dto.firstName = us.getFirstName();
    	dto.email = us.getEmail();
    	List<Sport> listOfFavoriteSports = us.getListOfFavoriteSports();
    	List<String> listOfFavoriteSportsName = new ArrayList<String>();
    	for(Sport sport : listOfFavoriteSports) {
    		listOfFavoriteSportsName.add(sport.getName());
    	}
    	dto.listOfFavoriteSports = listOfFavoriteSportsName;
    	List<Town> listOfFavoriteTowns = us.getListOfFavoriteTowns();
    	List<String> listOfFavoriteTownsName = new ArrayList<String>();
    	for(Town town : listOfFavoriteTowns) {
    		listOfFavoriteTownsName.add(town.getName());
    	}
    	dto.listOfFavoriteTowns = listOfFavoriteTownsName;
    	dto.listOfConstraints = us.getListOfPreferences();
    	
    	return dto;
    }
    
    public static boolean checkEmpty(String string) {
    	return string == null || string.trim().isEmpty();
    }
}
