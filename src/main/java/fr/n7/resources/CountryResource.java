package fr.n7.resources;

import fr.n7.entities.Country;
import fr.n7.services.CountryServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/countries")
public class CountryResource {
    @EJB
    private CountryServiceLocal countryServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAll(){
        return Response.ok(countryServiceLocal.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Country country){
        countryServiceLocal.save(country);
        return Response.status(Response.Status.CREATED).entity(country)
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        try{
            countryServiceLocal.delete(id);
            return Response.ok("Country has been deleted successfully")
                    .build();
        }catch (NotFoundException ex){
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}
