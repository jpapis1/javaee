package app.rest;

import app.domain.Parrot;
import app.service.OwnerManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("owner")
@Stateless
public class OwnerRestService {
    @Inject
    private OwnerManager om;
    @GET
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parrot> getOwnersParrots(@PathParam("ownerId") Integer id) {
        try {
            return om.getAllOwnersParrots(id);
        } catch (Exception e) {
            return null;
        }

    }
}
