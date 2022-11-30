package service;

import controller.JWTHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Trial;
import model.Company;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("company")
public class CompanyService {
    //TODO: replace with real database
    controller.HibernateController hibernateController = controller.HibernateController.getInstance();
    @GET
    public List<Company> getCompanies(@HeaderParam("Authorization") String authHeader) throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            // get the trial from the database with hibernate
            List<Company> company = session.createQuery("from Company", Company.class).list();
            transaction.commit();
            session.close();
            return company;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Company not found");
        }

    }

    @GET
    @Path("/{id}")
    public Company getCompany(@PathParam("id") int id) throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            // get the trial from the database with hibernate
            Company company = session.get(Company.class, id);
            transaction.commit();
            session.close();
            return company;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Company not found");
        }

    }

}
