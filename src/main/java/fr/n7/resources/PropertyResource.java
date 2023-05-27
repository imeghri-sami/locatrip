package fr.n7.resources;

import fr.n7.entities.Property;
import fr.n7.services.PropertyServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/properties")
public class PropertyResource {

    @EJB
    private PropertyServiceLocal propertyServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAll(){
        return Response
                .ok(propertyServiceLocal.findAll())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAllByType(@PathParam("type") String type){
        return Response
                .ok(propertyServiceLocal.findByType(type))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Property property){
        propertyServiceLocal.save(property);

        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        try {
            propertyServiceLocal.delete(id);
            return Response.ok("Property has been deleted successfully").build();
        }catch( NotFoundException e ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    // TODO : disable a property



}
