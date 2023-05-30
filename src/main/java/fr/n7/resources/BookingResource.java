package fr.n7.resources;

import fr.n7.entities.Booking;
import fr.n7.services.BookingServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/bookings")
public class BookingResource {
    @EJB
    private BookingServiceLocal bookingServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAllBookingByUserId(@QueryParam("user_id") int userId){
        return Response.ok(bookingServiceLocal.findByUeserId(userId)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Booking booking){

        if (booking.getCheckInDate().compareTo(booking.getCheckOutDate()) > 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Booking check in date must be before the check out date.")
                    .build();
        }

        booking.setBookingDate(new Date());

        bookingServiceLocal.save(booking);
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }

}
