package fr.n7.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/booking")
public class BookingResource {
    // TODO : add booking methods
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAllBookingByUserId(){
        throw new UnsupportedOperationException("BookingResource::retrieveAllBookingByUserId is not implemented");
    }
}
