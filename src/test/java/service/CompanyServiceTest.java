package service;

import model.Company;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    // test the getCompanies method
    @org.junit.jupiter.api.Test
    void getCompanies() {
        // create a new instance of the service
        CompanyService companyService = new CompanyService();
        // call the getCompanies method
        List<Company> companies = companyService.getCompanies();
        // check that the list is not null
        assertNotNull(companies);
        // check that the list is not empty
        assertFalse(companies.isEmpty());
        // check that the first company in the list has the expected name
        assertEquals("BSucker", companies.get(0).getCompanyName());
    }

    // test the getCompany method with a valid id
    @org.junit.jupiter.api.Test
    void getCompany() {
        // create a new instance of the service
        CompanyService companyService = new CompanyService();
        // call the getCompany method with a valid id
        Company company = companyService.getCompany(1);
        // check that the company is not null
        assertNotNull(company);
        // call the getCompany method with an invalid id
        Company company2 = companyService.getCompany(0);
        // check that the company is null
        assertNull(company2);
        // check that the company has the expected name
        assertEquals("BSucker", company.getCompanyName());
        // check that the company has the expected email
        assertEquals("vamp@ink.com", company.getEmail());
    }
}