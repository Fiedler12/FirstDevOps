package service;

import controller.JWTHandler;
import model.Company;
import model.User;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    // test the getCompanies method
    @org.junit.jupiter.api.Test
    void getCompanies() throws NotAuthorizedException {
        // create a new instance of the service
        CompanyService companyService = new CompanyService();
        // get a valid token
        String token = JWTHandler.generateJwtToken(new User());
        // call the getCompanies method
        List<Company> companies = companyService.getCompanies(token);
        // check that the list is not null
        assertNotNull(companies);
        // check that the list is not empty
        assertFalse(companies.isEmpty());
    }

    // test the getCompany method with a valid id
    @org.junit.jupiter.api.Test
    void getCompany() throws NotAuthorizedException {

        // create a new instance of the service
        CompanyService companyService = new CompanyService();
        // get a valid token
        String token = JWTHandler.generateJwtToken(new User());
        // call the getCompany method with a valid id
        Company company = companyService.getCompany(52);
        // check that the company is not null
        assertNotNull(company);
        // check that the company has the expected id
        assertEquals(52, company.getId());
        // check that the company has the expected name
        assertEquals("Test", company.getCompanyName());
        // check that the company has the expected email
        assertEquals("test@popo.com", company.getEmail());

    }
}