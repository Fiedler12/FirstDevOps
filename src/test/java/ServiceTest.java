import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import model.Trial;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.TrialsService;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceTest {

    private boolean isValidJSON(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

    @org.junit.Test
    public void testGetTrials() throws Exception {

        TrialsService trialsService = new TrialsService();
        List<Trial> response = trialsService.getTrials();

        for (Trial trial : response) {
            Assert.assertNotNull(trial.getId());
            Assert.assertNotNull(trial.getTrialname());
            Assert.assertNotNull(trial.getCompanyid());
        }

        //test if


    }



}
