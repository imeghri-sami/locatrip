package fr.n7.resources;

import fr.n7.entities.Property;
import fr.n7.entities.PropertyImages;
import fr.n7.services.PropertyImageServiceLocal;
import fr.n7.resources.requests.ImageRequest;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;

@Path("/images")
public class PropertyImageResource {

    @EJB
    private PropertyImageServiceLocal propertyImageServiceLocal;
    @Context
    private HttpServletRequest httpRequest;

    @GET
    @Path("/{id}")
    @Produces("image/*")
    public Response retrieveImage(@PathParam("id") String id){

        // Retrieve the image data from the database
        PropertyImages propertyImage = propertyImageServiceLocal.findOne(UUID.fromString(id)).orElseThrow(NotFoundException::new);

        try {
            File imageFile = new File(
                    this.getClass()
                            .getClassLoader()
                            .getResource("images/"+propertyImage.getId())
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upload (ImageRequest imageRequest){

        try {
            // Extract base64 image and filename from the map
            String base64Image = imageRequest.getImage();
            UUID fileName = UUID.randomUUID();

            // Convert base64 string to byte array
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

            // Save the image to the file system
            saveImageToFileSystem(decodedBytes, fileName.toString());
            saveImageToDB(fileName, imageRequest.getPropertyId());

            return Response.ok("Image uploaded successfully.").build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }


    }

    private void saveImageToDB(UUID id, int propertyId) {
        PropertyImages propertyImages = new PropertyImages();

        Property property = new Property();
        property.setId(propertyId);
        propertyImages.setId(id);
        propertyImages.setProperty(property);
        propertyImages.setImagePath(getDeploymentURL() + "/images/" + id.toString());
        propertyImageServiceLocal.save(propertyImages);

    }

    public String getDeploymentURL() {
        String deploymentURL = httpRequest.getRequestURL().toString();
        String contextPath = httpRequest.getContextPath();

        // Remove the context path from the deployment URL
        //deploymentURL = deploymentURL.replace(contextPath, "")
        return deploymentURL;
    }

    private static final String UPLOAD_DIRECTORY = "src/main/resources/images/";
    private void saveImageToFileSystem(byte[] imageData, String filename) throws IOException {
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        java.nio.file.Path imagePath = java.nio.file.Paths.get(UPLOAD_DIRECTORY, filename);
        System.out.println(imagePath);
        Files.write(imagePath, imageData);

    }

}
