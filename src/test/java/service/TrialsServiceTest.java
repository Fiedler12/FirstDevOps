package service;

import model.Trial;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrialsServiceTest {
        // test the getTrials method
        @org.junit.jupiter.api.Test
        void getTrials() {
            // create a new instance of the service
            TrialsService trialsService = new TrialsService();
            // call the getTrials method
            List<Trial> trials = trialsService.getTrials();
            // check that the list is not null
            assertNotNull(trials);
            // check that the list is not empty
            assertFalse(trials.isEmpty());
            // check that the list contains the expected number of trials
            assertEquals(4, trials.size());
            // check that the first trial in the list has the expected name
            assertEquals("GoodSuckin", trials.get(0).getTrialname());
        }

        // test the getTrial method with a valid id
        @org.junit.jupiter.api.Test
        void getTrials1() {
            // create a new instance of the service
            TrialsService trialsService = new TrialsService();
            // call the getTrial method with a valid id
            Trial trial = trialsService.getTrials(2000);
            // check that the trial is not null
            assertNotNull(trial);
            // call the getTrial method with an invalid id
            Trial trial2 = trialsService.getTrials(1);
            // check that the trial is null
            assertNull(trial2);
            // check that the trial has the expected name
            assertEquals("GoodSuckin", trial.getTrialname());
            // check that the trial has the expected company
            // assertEquals("Novo Nordisk", trial.getCompany());
        }

}