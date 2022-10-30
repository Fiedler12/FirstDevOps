package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("test")
public class TestService {

        @GET
        public String getHello(){
            return "API is working";
        }
}
