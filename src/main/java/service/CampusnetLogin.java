package service;

import config.Config;
import controller.JWTHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
//import kong.unirest.Unirest;
import model.User;


@Path("campusnet")
public class CampusnetLogin {
    @GET
    @Path("login")
    public Response login() {
        String URI =  "https://auth.dtu.dk/dtu/?service=" + Config.CN_REDIRECT_URL;
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }
//    @GET
//    @Path("redirect")
//    public Response callback(@QueryParam("ticket") String cnTicket) throws NotAuthorizedException {
//        System.out.println(cnTicket);
//        // Tjekker ticket op mod campusnet
//        String body = Unirest.get( "https://auth.dtu.dk/dtu/validate?service="
//                        + Config.CN_REDIRECT_URL
//                        + "&ticket="
//                        + cnTicket)
//                .asString()
//                .getBody();
//
//        if (body.contains("yes")) {
//            int id = Integer.parseInt(body.replaceAll("[^0-9]+", ""));
//            System.out.println(id);
//            String tokenString = JWTHandler.generateJwtToken(new User(id));
//            return Response.seeOther(UriBuilder.fromUri(Config.FRONTEND_URL + "?token=" + tokenString).build()).build();
//            //return tokenString;
//        }
//        throw new NotAuthorizedException("You are not authorized");
//    }

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
