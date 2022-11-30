package service;

import model.Trial;
import model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrialsServiceTest {
    // test the getTrials method
    @org.junit.jupiter.api.Test
    void getTrials() throws NotAuthorizedException {
        // create a new instance of the service
        TrialsService trialsService = new TrialsService();
        // call the getTrials method
        List<Trial> trials = trialsService.getTrials();
        // check that the list is not null
        assertNotNull(trials);
        // check that the list is not empty
        assertFalse(trials.isEmpty());
        // check that the first trial in the list has a name that is not null
        assertNotNull(trials.get(0).getTrialname());
        // check that the first trial in the list has a description that is not null
        assertNotNull(trials.get(0).getDescription());
        // check that the first trial in the list has a location that is not null
        assertNotNull(trials.get(0).getLocation());
        // check that the first trial in the list has a id that is not null
        assertNotNull(trials.get(0).getId());
        // check that the first trial in the list has a company that is not null
        assertNotNull(trials.get(0).getCompany());
    }

    // test the getTrial method with a valid id
    @org.junit.jupiter.api.Test
    void getTrial() throws NotAuthorizedException {
        // create a new instance of the service
        TrialsService trialsService = new TrialsService();
        // call the getTrial method with a valid id
        Trial trial = trialsService.getTrial(1453);
        // check that the trial is not null
        assertNotNull(trial);
        // check that the trial has the expected id
        assertEquals(1453, trial.getId());
        // check that the trial has the expected name
        assertEquals("Newtest", trial.getTrialname());
        // check that the trial has the expected description
        assertEquals("Lorem epsium", trial.getDescription());
        // check that the trial has the expected location
        assertEquals("KBH", trial.getLocation());
    }

    // test the createTrial method
    @org.junit.jupiter.api.Test
    void createTrial() throws NotAuthorizedException {
        // create a new instance of the service
        TrialsService trialsService = new TrialsService();
        // create a new instance of the model
        Trial trial = new Trial();
        // set the name of the trial
        trial.setTrialname("Test");
        // set the description of the trial
        trial.setDescription("Lorem epsium");
        // set the location of the trial
        trial.setLocation("KBH");
        // call the createTrial method
        Trial createdTrial = trialsService.createTrial(trial);
        // check that the created trial is not null
        assertNotNull(createdTrial);
        // check that the created trial has the expected name
        assertEquals("Test", createdTrial.getTrialname());
        // check that the created trial has the expected description
        assertEquals("Lorem epsium", createdTrial.getDescription());
        // check that the created trial has the expected location
        assertEquals("KBH", createdTrial.getLocation());
        // delete the created trial
        trialsService.deleteTrial(createdTrial);
        // check that the trial is deleted
        assertNull(trialsService.getTrial(createdTrial.getId()));
    }
    // test the subscribe method
    @org.junit.jupiter.api.Test
    void subscribe() throws NotAuthorizedException {
        // create a new instance of the service
        TrialsService trialsService = new TrialsService();
        // call the subscribe method
        int trial = trialsService.subscribe(1502, 202);
        // check that the trial got 200 as a response
        assertEquals(200, trial);
        // check that the subscription is created
        assertTrue(trialsService.isSubscribed(1502, 202));
        // call the unsubscribe method
        trialsService.unsubscribe(1502, 202);
        // check that the subscription is deleted
        assertFalse(trialsService.isSubscribed(1502, 202));
    }

    // test the getDiseaseSpecific method
    @org.junit.jupiter.api.Test
    void getDiseaseSpecific() throws NotAuthorizedException {
        // create a new instance of the service
        TrialsService trialsService = new TrialsService();
        // call the getDiseaseSpecific method
        List<Trial> trials = trialsService.getDiseaseSpecific(1);
        // check that the list is not null
        assertNotNull(trials);
        // check that the list is not empty
        assertFalse(trials.isEmpty());
        // check that the first trial in the list has a name that is not null
        assertNotNull(trials.get(0).getTrialname());
        // check that the first trial in the list has a description that is not null
        assertNotNull(trials.get(0).getDescription());
        // check that the first trial in the list has a location that is not null
        assertNotNull(trials.get(0).getLocation());
        // check that the first trial in the list has a id that is not null
        assertNotNull(trials.get(0).getId());
        // check that the first trial in the list has a company that is not null
        assertNotNull(trials.get(0).getCompany());
    }



}