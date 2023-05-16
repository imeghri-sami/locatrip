package fr.n7.resources;

import fr.n7.services.PropertyServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/properties")
public class PropertyRessource {

    @EJB
    private PropertyServiceLocal propertyServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAll(){
        return Response
                .ok(propertyServiceLocal.findAll())
                .build();
    }

}
