package app.rest;

import app.domain.Basket;
import app.domain.Parrot;
import app.service.BasketManager;
import app.service.OwnerManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("basket")
@Stateless
public class BasketRestService {
    @Inject
    private BasketManager bm;

    @GET
    @Path("/{basketId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Basket getBasket(@PathParam("basketId") Integer id) {
        try {
            Basket b = bm.getBasket(id);
            System.out.println(b);
            return b;
        } catch (Exception e) {
            return null;
        }

    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Integer createBasket() {
        int id = bm.createBasket();
        return id;
    }

    @POST
    @Path("/{basketId}/{parrotId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToBasket(@PathParam("basketId") int basketId, @PathParam("parrotId") int parrotId) {
        bm.addToBasket(basketId,parrotId);
        return Response.status(201).entity("Basket").build();
    }
    @DELETE
    @Path("/{basketId}/{parrotId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeFromBasket(@PathParam("basketId") int basketId, @PathParam("parrotId") int parrotId) {
        bm.removeFromBasket(basketId,parrotId);
        return Response.status(201).entity("Basket").build();
    }
}
