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
import dao.impl.DepartmentDAOImpl;
import domain.Department;
import domain.Town;
import dto.DepartmentTO;

@Path("/department")
public class DepartmentEndPoint {
	private static final Logger logger = Logger.getLogger(DepartmentEndPoint.class.getName());

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity("Ok pour les départements !").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public Response helloWorld() {
		String helloWorld = "Ok pour Hello World DEPARTMENT !";
		return Response.status(Response.Status.OK).entity(helloWorld).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getDepartmentById(@PathParam("id") Long id) {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		Department dept = deptDao.findById(id);
		return Response.status(Response.Status.OK).entity(createDepartmentTO(dept)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/region")
	public Response getRegionOfDepartment(@PathParam("id") Long id) {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		Department dept = deptDao.findById(id);
		return Response.status(Response.Status.OK).entity(createDepartmentTO(dept).region.getName()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/towns")
	public Response getTownsOfDepartment(@PathParam("id") Long id) {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		Department dept = deptDao.findById(id);
		return Response.status(Response.Status.OK).entity(displayListOfTowns(createDepartmentTO(dept))).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepartmentTO> getAllDepartments() {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		List<DepartmentTO> listOfDepartments = new ArrayList<DepartmentTO>();
		for (Department dept : deptDao.findAll(new Department())) {
			listOfDepartments.add(createDepartmentTO(dept));
		}
		return listOfDepartments;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDepartment(DepartmentTO departmentTo) {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		Department dept = new Department();
		dept.setName(departmentTo.name);
		dept.setRegion(departmentTo.region);
		deptDao.save(dept);
		return Response.status(Response.Status.CREATED).entity(createDepartmentTO(dept)).build();
	}

	@DELETE
	@Path("{id}")
	public Response removeDepartment(@PathParam("id") Long id) {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		deptDao.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response modifyDepartment(@PathParam("id") Long id, DepartmentTO departmentTo) {
		IDAO<Department> deptDao = new DepartmentDAOImpl();
		Department dept = deptDao.findById(id);
		if (!checkEmpty(departmentTo.name)) {
			dept.setName(departmentTo.name);
		}
		dept = deptDao.save(dept);
		return Response.status(Response.Status.OK).entity(createDepartmentTO(dept)).build();
	}

	public DepartmentTO createDepartmentTO(Department department) {
		DepartmentTO dto = new DepartmentTO();
		dto.id = department.getId();
		dto.region = department.getRegion();
		dto.name = department.getName();
		List<String> listOfNamesOfTowns = new ArrayList<String>();
		for (Town town : department.getListOfTowns()) {
			listOfNamesOfTowns.add(town.getName());
		}
		dto.listOfTowns = listOfNamesOfTowns;
		return dto;
	}

	public static boolean checkEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

	public String displayListOfTowns(DepartmentTO departmentTo) {
		String listOfTowns = "";
		for (String town : departmentTo.listOfTowns) {
			listOfTowns += (town + "\n");
		}
		return listOfTowns;
	}
}
