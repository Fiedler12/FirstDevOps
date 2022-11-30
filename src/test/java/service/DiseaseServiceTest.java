package service;

import model.Disease;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiseaseServiceTest {

    // test the getDiseases method
    @org.junit.jupiter.api.Test
    void getDiseases() {
        // create a new instance of the service
        DiseaseService diseaseService = new DiseaseService();
        // call the getDiseases method
        List<Disease> diseases = diseaseService.getDiseases();
        // check that the list is not null
        assertNotNull(diseases);
        // check that the list is not empty
        assertFalse(diseases.isEmpty());
        // check that the first disease in the list has a name that is not null
        assertNotNull(diseases.get(1).getName());
        assertEquals("Cancer", diseases.get(1).getName());
        // check that the first disease in the list has a id that is not null
        assertNotNull(diseases.get(0).getId());

    }
}