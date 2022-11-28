package service;

import controller.HibernateController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Company;
import model.Disease;
import model.Trial;
import model.TrialDisease;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.ArrayList;
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

    @GET
    @Path("disease={id}")
    public List<Trial> getDiseaseSpecificTrial(@PathParam("id")int id) throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Trial> trials = session.createQuery("from Trial", Trial.class).list();
            transaction.commit();
            session.close();
            List<Trial> result = new ArrayList<>();
            for (Trial trial : trials) {
                for (TrialDisease trialDisease : trial.getTrialDiseases()) {
                    Disease disease = trialDisease.getTrialDiseaseId().getDisease();
                    if (disease.getId() == id) {
                        result.add(trial);
                    }
                }
            }
            return result;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Trials not found");

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
}
