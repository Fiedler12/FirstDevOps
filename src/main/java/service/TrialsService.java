package service;

import controller.HibernateController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Company;
import model.Trial;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("trials")
public class TrialsService {
    //TODO: replace with real database
    controller.HibernateController hibernateController = controller.HibernateController.getInstance();
    @GET
    public List<Trial> getTrials() throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Trial> trials = session.createQuery("from Trial", Trial.class).list();
            System.out.println(trials);
            transaction.commit();
            session.close();
            return trials;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Trial not found");
        }
    }

    @POST
    @Path("/init")
    public void init() {
        HibernateController hibernateController = HibernateController.getInstance();
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{;
            Company company = new Company();
            company.setCompanyName("Test");
            company.setEmail("test@popo.com");
            session.persist(company);
            Company company1 = new Company();
            company1.setCompanyName("Test2");
            company1.setEmail("test@Trans.com");
            session.persist(company1);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }

    @GET
    @Path("/{id}")
    public Trial getTrial(@PathParam("id") int id) throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            // get the trial from the database with hibernate
            Trial trial = session.get(Trial.class, id);
            System.out.println(trial);
            transaction.commit();
            session.close();
            return trial;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Trial not found");
        }
    }

    @POST
    public Trial createTrial(Trial trial) throws NotAuthorizedException {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(trial);
            transaction.commit();
            session.close();
            return trial;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Trial not created");
        }
    }

    @GET
    public List<Trial> getSpecificDisease() throws NotAuthorizedException {}
}
