package fr.n7.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/promo-code")
public class PromoCodeResource {
    // TODO : add promo-code methods create() and delete()
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAll(){
        throw new UnsupportedOperationException("PromoCodeResource::retrieveAll is not implemented");
    }
}
