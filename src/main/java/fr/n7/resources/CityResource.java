package fr.n7.resources;

import fr.n7.entities.City;
import fr.n7.services.CityServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cities")
public class CityResource {
    @EJB
    private CityServiceLocal cityServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAll() {
        return Response.ok(cityServiceLocal.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(City city) {
        cityServiceLocal.save(city);
        return Response.status(Response.Status.CREATED).entity(city)
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            cityServiceLocal.delete(id);
            return Response.ok("City has been deleted successfully")
                    .build();
        } catch (NotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}
