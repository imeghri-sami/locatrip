package fr.n7.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/hello")
public class Hello {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello() {
        Map<String, String> hello = new HashMap<>();
        hello.put("msg", "Hello");
        return Response.ok(hello).build();
    }
}
