package fr.n7.resources;

import fr.n7.entities.PropertyImages;
import fr.n7.services.PropertyImageServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Path("/images")
public class PropertyImageResource {

    @EJB
    private PropertyImageServiceLocal propertyImageServiceLocal;

    @GET
    @Path("/{id}")
    @Produces("image/*")
    public Response retrieveImage(@PathParam("id") Integer id){

        // Retrieve the image data from the database
        PropertyImages propertyImage = propertyImageServiceLocal.findOne(id).orElseThrow(NotFoundException::new);

        try {
            File imageFile = new File(
                    this.getClass()
                            .getClassLoader()
                            .getResource(propertyImage.getImagePath())
                            .getFile()
            );

            //File imageFile = new File(this.getClass().getClassLoader().getResource("images/1.jpg").toURI());

            if ( !imageFile.exists() ) {
                System.err.println("file not found");throw new FileNotFoundException();}

            // Read the image file
            FileInputStream fileInputStream = new FileInputStream(imageFile);

            // Return the image with status code 200
            return Response.ok(fileInputStream).build();
        }catch ( FileNotFoundException e ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    /*@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload (@FormParam("file") InputStream fileInputStream,
                           @FormParam("property-id") Integer propertyId){


    }*/

}
