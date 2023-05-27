package fr.n7.resources;

import fr.n7.entities.User;
import fr.n7.services.UserServiceLocal;
import fr.n7.services.utils.JWTUtils;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @EJB
    private UserServiceLocal userServiceLocal;

    @POST
    @Path("/authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@FormParam("email") String email, @FormParam("password") String passwd){
        try{
            User user = userServiceLocal.findByEmail(email).orElseThrow(NotFoundException::new);

            String token = JWTUtils.generateToken(user.getEmail());


            // Validate the credentials and send response
            return user.getPassword().equals(passwd) // TODO : hash the password
                    ? Response.ok(token).build()
                    : Response.status(Response.Status.FORBIDDEN).build();

        }catch (NotFoundException e){
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .build();
        }
    }

    @POST
    @Path("/register")
    public Response register (User user) {

        if ( userServiceLocal.isEmailExists(user.getEmail()) )
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity("User already exists with this email")
                    .build();


        userServiceLocal.save(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    // TODO : retrieve a user by its email

}
