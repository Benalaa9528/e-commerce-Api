package com.jets.admin.rest;



import com.jets.admin.dao.AdminDao;

import com.jets.admin.dtos.AdminPutRequest;
import com.jets.admin.service.AdminService;
import com.jets.login.CheckerDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("admins")
public class AdminController {

	@GET
	public Response getAllAdmins(){
		AdminService service=new AdminService(new AdminDao());
		var admins=service.getAllAdmins();
		if(admins != null){
			return  Response.ok().entity(admins).build();
		}
		return Response.status(Response.Status.FORBIDDEN).build();
	}

	@GET
	@Path("{id}")
	public Response getAdminProfile(@PathParam("id") int id,@HeaderParam("LoginId") String uuid) {
		CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(uuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
			AdminService service=new AdminService(new AdminDao());
			var admin=service.getAdminInfo(id);
			return  Response.ok().entity(admin).build();
		}
		return Response.status(Response.Status.FORBIDDEN).build();
		
	}
	

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAdmin(@PathParam("id") int id, AdminPutRequest admin,@HeaderParam("LoginId") String uuid) {
		CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(uuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
			AdminService service=new AdminService(new AdminDao());
			var updatedAdmin=service.updateAdminInfo(id, admin);
			return  Response.ok().entity(updatedAdmin).build();
		}
		return Response.status(Response.Status.FORBIDDEN).build();
	}

}
