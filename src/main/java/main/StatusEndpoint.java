package main;

import domain.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.impl.UserDAOImpl;
import dto.UserTO;


@Path("/apiwe")
public class StatusEndpoint {

    private static final Logger logger = Logger.getLogger(StatusEndpoint.class.getName());

    @GET
    public Response getStatus() {

        return Response.status(Response.Status.OK).entity("c'est bon yo!").build();
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
    	dto.name = us.getName();
    	dto.firstName = us.getFirstName();
    	dto.email = us.getEmail();
    	dto.listOfFavoriteSports = us.getListOfFavoriteSports();
    	dto.listOfFavoriteTowns = us.getListOfFavoriteTowns();
    	dto.listOfConstraints = us.getListOfConstraints();
    	
    	return dto;
    }

}
