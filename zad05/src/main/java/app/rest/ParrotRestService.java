package app.rest;

import app.domain.Parrot;
import app.service.ParrotManager;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("parrot")
@Stateless
public class ParrotRestService {

	@Inject
	private ParrotManager pm;

	@GET
	@Path("/{parrotId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Parrot getParrot(@PathParam("parrotId") Integer id) {
	    try {
            Parrot p = pm.getParrot(id);
            return p;
        } catch (Exception e) {
	        return null;
        }

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Parrot> getParrots() {
		return pm.getAllParrots();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addParrot(Parrot parrot) {
		pm.addParrot(parrot);

		return Response.status(201).entity("Parrot").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Parrot test() {
		return new Parrot("Nimfa",new Date(),0.4,true);
	}

	@DELETE
	public Response clearParrots() {
		pm.deleteAllParrots();
		return Response.status(200).build();
	}

}
