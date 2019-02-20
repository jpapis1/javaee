package app.rest;

import app.domain.Country;
import app.domain.Owner;
import app.domain.Parrot;
import app.domain.ParrotStats;
import app.service.OwnerManager;
import app.service.ParrotManager;
import app.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("parrot")
@Stateless
public class ParrotRestService {

	@Inject
	private ParrotManager pm;
	@Inject
	private OwnerManager om;
	@GET
	@Path("/{parrotId}")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.DetailedParrotInfo.class)
	public Parrot getParrot(@PathParam("parrotId") Integer id) {
	    try {

            return pm.getParrot(id);
        } catch (Exception e) {
	        return null;
        }

	}
	@GET
	@Path("/{parrotId}/basic")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.BasicParrotInfo.class)
	public Parrot getBasicParrot(@PathParam("parrotId") Integer id) {
		try {
			return pm.getParrot(id);
		} catch (Exception e) {
			return null;
		}

	}
	@GET
	@Path("/getAvgWeight/{color}")
	@Produces(MediaType.APPLICATION_JSON)
	public Double getAvgWeightByColor(@PathParam("color") String color) {

		try {double d = pm.getAverageWeightByColor(color); return d;
		} catch (Exception e) {
			return null;
		}
	}
	@GET
	@Path("/{date1}/{date2}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Parrot> getParrotsConsideringDates(@PathParam("date1") String from, @PathParam("date2") String to) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date fDate = format.parse(from);
			Date tDate = format.parse(to);
			return pm.getParrotsConsideringDates(fDate, tDate);
		} catch (Exception e) {
			return null;
		}

	}
    @GET
    @Path("/{parrotId}/owner")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner getParrotsOwner(@PathParam("parrotId") Integer id) {
        try {
            return pm.getParrot(id).getOwner();
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
    @Produces(MediaType.TEXT_PLAIN)
	public int addParrot(Parrot parrot) {
		int id = pm.addParrot(parrot);
		return id;
	}

	@GET
	@Path("/byColorAndOwner/{color}/{fName}/{lName}")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.BasicParrotInfo.class)
	public List<Parrot> getParrotsOfSpecificColorAndOwner(@PathParam("color") String color,
														  @PathParam("fName") String firstName,
														  @PathParam("lName") String lastName) {
		return 	pm.getParrotsOfSpecificColorAndOwner(color,firstName,lastName);
	}

	@DELETE
	public Response clearParrots() {
		pm.deleteAllParrots();
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{parrotId}")
	public Response deleteParrot(@PathParam("parrotId") Integer id) {
		if(pm.deleteParrot(id)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{parrotId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateParrot(@PathParam("parrotId") Integer id,Parrot parrot) {
		if(pm.updateParrot(id,parrot))
		return Response.status(200).build();
		else return Response.status(404).build();
	}

}
