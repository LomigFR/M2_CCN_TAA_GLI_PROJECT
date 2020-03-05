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

import org.w3c.dom.ls.LSInput;

import dao.IDAO;
import dao.impl.RegionDAOImpl;
import dao.impl.TownDAOImpl;
import domain.Department;
import domain.Region;
import domain.Sport;
import domain.Town;
import domain.User;
import dto.RegionTO;
import dto.TownTO;

@Path("/regions")
public class RegionEndPoint {
	private static final Logger logger = Logger.getLogger(RegionEndPoint.class.getName());

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity("Ok pour les régions !").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public Response helloWorld() {
		String helloWorld = "Ok pour Hello World REGION !";
		return Response.status(Response.Status.OK).entity(helloWorld).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getRegionById(@PathParam("id") Long id) {
		IDAO<Region> regionDao = new RegionDAOImpl();
		Region region = regionDao.findById(id);
		return Response.status(Response.Status.OK).entity(createRegionTO(region)).build();
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/sports")
	public Response getDepartmentsOfRegion(@PathParam("id") Long id) {
		IDAO<Region> regionDao = new RegionDAOImpl();
		Region region= regionDao.findById(id);
		return Response.status(Response.Status.OK).entity(displayListOfDepartments(createRegionTO(region))).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RegionTO> getAllRegions() {
		IDAO<Region> regionDao = new RegionDAOImpl();
		List<RegionTO> listOfRegions = new ArrayList<RegionTO>();
		for(Region region : regionDao.findAll(new Region())) {
			listOfRegions.add(createRegionTO(region));
		}
		return listOfRegions;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createRegion(RegionTO regionTo) {
		IDAO<Region> regionDao = new RegionDAOImpl();
		Region region = new Region();
		region.setName(regionTo.name);
		regionDao.save(region);
		return Response.status(Response.Status.CREATED).entity(createRegionTO(region)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response removeRegion(@PathParam("id") Long id) {
		IDAO<Region> regionDao = new RegionDAOImpl();
		regionDao.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response modifyRegion(@PathParam("id") Long id, RegionTO regionTo) {
		IDAO<Region> regionDao = new RegionDAOImpl();
		Region region = regionDao.findById(id);
		if (!checkEmpty(regionTo.name)) {
			region.setName(regionTo.name);
		}
		region = regionDao.save(region);
		return Response.status(Response.Status.OK).entity(createRegionTO(region)).build();
	}

	public RegionTO createRegionTO(Region region) {
		RegionTO rto = new RegionTO();
		rto.id = region.getId();
		rto.name = region.getName();
		List<String> listOfNamesOfdepartments = new ArrayList<String>();
		for (Department dept: region.getListOfDepartments()){
			listOfNamesOfdepartments.add(dept.getName());
		}
		rto.listOfDepartments = listOfNamesOfdepartments;
		return rto;
	}

	public static boolean checkEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

	public String displayListOfDepartments(RegionTO regionTo) {
		String listOfDepartments = "";
		for (String dept : regionTo.listOfDepartments) {
			listOfDepartments += (dept + "\n");
		}
		return listOfDepartments;
	}
}
