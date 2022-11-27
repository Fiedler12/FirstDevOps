package service;

import controller.JWTHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import kong.unirest.Unirest;
import model.User;


@Path("campusnet")
public class CampusnetLogin {
    @GET
    @Path("login")
    public Response login() {
        String URI =  "https://auth.dtu.dk/dtu/?service=http://localhost:8080/api/campusnet/redirect";
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }
    @GET
    @Path("redirect")
    public String callback(@QueryParam("ticket") String cnTicket) throws NotAuthorizedException {
        System.out.println(cnTicket);
        // Tjekker ticket op mod campusnet
        String body = Unirest.get( "https://auth.dtu.dk/dtu/validate?service=http://localhost:8080/api/campusnet/redirect&ticket="
                        + cnTicket)
                .asString()
                .getBody();

        if (body.contains("yes")) {
            int id = Integer.parseInt(body.replaceAll("[^0-9]+", ""));
            System.out.println(id);
            String tokenString = JWTHandler.generateJwtToken(new User(id));
            return tokenString;
        }
        throw new NotAuthorizedException("You are not authorized");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("testtoken")
    public User testToken(@HeaderParam("Authorization") String token) {
        System.out.println(token);
        User validate = JWTHandler.validate(token);
        System.out.println(validate);
        return validate;
    }
}
