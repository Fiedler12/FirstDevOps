package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("gettrials")
public class TrialsService {
    //TODO: replace with real database
    List<String> trials = Arrays.asList("Melman", "Elmer");
    @GET
    public List<String> getTrials(){
        return trials;
    }

}
