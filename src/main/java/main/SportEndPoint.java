package main;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/sport")
public class SportEndPoint {

    private static final Logger logger = Logger.getLogger(SportEndPoint.class.getName());

    @GET
    public Response getStatus() {
    	
    	return Response.status(Response.Status.OK).entity("Ok pour les sports").build();
    }
    
    @GET
    @Path("/test")
    public String helloWorld() {
    	return "Ok pour Hello World !";
    }
}
