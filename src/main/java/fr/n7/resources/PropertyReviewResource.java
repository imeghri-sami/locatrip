package fr.n7.resources;

import fr.n7.entities.PropertyReview;
import fr.n7.services.PropertyReviewServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/comments")
public class PropertyReviewResource {
    @EJB
    private PropertyReviewServiceLocal propertyReviewServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // TODO : add page and size of retrieved entities
    public Response retrieveComments(@QueryParam("propertyId") int propertyId){
        return Response.
                ok(propertyReviewServiceLocal.retrieveAllByPropertyId(propertyId))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(PropertyReview propertyReview){
        // TODO : add comment to a property
        throw new UnsupportedOperationException("PropertyReviewResource::addComment is not implemented");
    }

}
