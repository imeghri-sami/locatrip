package fr.n7.resources;

import fr.n7.entities.Property;
import fr.n7.resources.dto.PropertyDTO;
import fr.n7.services.PropertyServiceLocal;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/properties")
@Transactional
public class PropertyResource {

    @EJB
    private PropertyServiceLocal propertyServiceLocal;

    private List<PropertyDTO> toDTO(List<Property> properties){
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        properties.forEach( p -> propertyDTOS.add(new PropertyDTO(p)));
        return propertyDTOS;
    }

    private PropertyDTO toDTO(Property property){
        return new PropertyDTO(property);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAll(){
        return Response
                .ok(toDTO(propertyServiceLocal.findAll()))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAllByType(@QueryParam("type") String type){
        return Response
                .ok(toDTO(propertyServiceLocal.findByType(type)))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Property property){

        if (property.getPrice() <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Property price must be greater than zero.")
                    .build();
        }
        if (property.getAvailabilityStartDate().compareTo(property.getAvailabilityEndDate()) >= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Property availability start date must be before the end date.")
                    .build();
        }
        if(property.getBedCount() < 0){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Property BedCount must be greater than zero.")
                    .build();
        }
        if(property.getGuestCount() < 0){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Property GuestCount must be greater than zero.")
                    .build();
        }
        if(property.getBedroomCount() < 0){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Property BedroomCount must be greater than zero.")
                    .build();
        }

        propertyServiceLocal.save(property);
        return Response.status(Response.Status.CREATED).entity(toDTO(property)).build();

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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveById(@PathParam("id") int id){
        try{
            Property p = propertyServiceLocal.findOne(id).orElseThrow(NotFoundException::new);
            return Response.ok(toDTO(p)).build();
        }catch (NotFoundException ex){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Response search(@QueryParam("q") String q){
        return Response.ok().build();
    }


}
