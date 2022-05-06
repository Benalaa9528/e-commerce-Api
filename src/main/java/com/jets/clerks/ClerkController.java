package com.jets.clerks;

import com.jets.clerks.dao.ClerkDao;
import com.jets.clerks.dto.ClerkPostDto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("clerks")
public class ClerkController {
    @GET
    public Response getAllClerks() {
        ClerkDao clerkDao = new ClerkDao();
        var clerks = clerkDao.getAllClerks();
        if (clerks != null) {
            return Response.ok().entity(clerks).build();
        }
        throw new NotFoundException("clerk not found");
    }
    @GET
    @Path("{id}")
    public Response getClerkById(@PathParam("id") int id) {
        ClerkDao clerkDao = new ClerkDao();
        var clerks = clerkDao.getClerkById(id);
        if (clerks != null) {
            return Response.ok().entity(clerks).build();
        }
        throw new NotFoundException("clerk not found");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addClerk(ClerkPostDto clerkPostDto){
        if(clerkPostDto.getRole().equalsIgnoreCase("clerk")){
            ClerkDao clerkDao = new ClerkDao();
            clerkDao.addClerk(clerkPostDto);
            return Response.ok().entity("clerk is added").build();
        }
        return Response.ok().entity("clerk can not be added").build();
        // throw new NotFoundException("clerk not found");
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClerk(@PathParam("id") int id,ClerkPostDto clerkPostDto){
        if(clerkPostDto.getRole().equalsIgnoreCase("clerk")){
            ClerkDao clerkDao = new ClerkDao();
            clerkDao.updateClerk(id,clerkPostDto);
            return Response.ok().entity("clerk is updated").build();
        }
        throw new NotFoundException("clerk not found");
    }

    @DELETE
    @Path("{id}")
    public Response deleteClerkById(@PathParam("id") int id){
        ClerkDao clerkDao = new ClerkDao();
       Boolean isDeleted= clerkDao.deleteClerkById(id);
       if(isDeleted){
        return Response.ok().entity("clerk is deleted").build();
       }
       throw new NotFoundException("clerk not found");
    }



}
