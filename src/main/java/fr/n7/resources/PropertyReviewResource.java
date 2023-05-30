package fr.n7.resources;

import fr.n7.entities.PropertyReview;
import fr.n7.resources.dto.PropertyReviewDTO;
import fr.n7.services.PropertyReviewServiceLocal;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Path("/comments")
@Transactional
public class PropertyReviewResource {
    @EJB
    private PropertyReviewServiceLocal propertyReviewServiceLocal;

    private PropertyReviewDTO toDTO(PropertyReview pr){
        return new PropertyReviewDTO(pr);
    }

    private List<PropertyReviewDTO> toDTO(List<PropertyReview> propertyReviews){
        return propertyReviews.stream()
                .map(PropertyReviewDTO::new)
                .collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // TODO : add page and size of retrieved entities
    public Response retrieveComments(@QueryParam("propertyId") int propertyId){
        return Response.
                ok(toDTO(propertyReviewServiceLocal.retrieveAllByPropertyId(propertyId)))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(PropertyReview propertyReview){
        try {

            if( propertyReview.getRating() < 0 ){
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Rating must be greater than zero.")
                        .build();
            }

            propertyReview.setAdded(new Date());
            propertyReviewServiceLocal.save(propertyReview);
            return Response.status(Response.Status.CREATED).entity(propertyReview).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
