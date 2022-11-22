package service;

import controller.HibernateController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Company;
import model.Disease;
import model.Trial;
import model.TrialDiseases;
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
    public List<Trial> getTrials() {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        List<Trial> trials = session.createQuery("from Trial", Trial.class).list();
        System.out.println(trials);
        transaction.commit();
        session.close();
        return trials;
    }

    @GET
    @Path("/{id}")
    public Trial getTrial(@PathParam("id") int id) {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        Trial trial = session.get(Trial.class, id);
        System.out.println(trial);
        transaction.commit();
        session.close();
        return trial;
    }

    @POST
    public Trial createTrial(Trial trial) {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(trial);
        transaction.commit();
        session.close();
        return trial;
    }

    @GET
    @Path("/disease/{id}")
    public List<Trial> getDiseaseTrials(@PathParam("id") int id) {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Trial> trials = session.createQuery("from Trial", Trial.class).list();
        List<Trial> result = new ArrayList<>();
        for (Trial trial : trials) {
            for (TrialDiseases trialDiseases : trial.getTrialDiseases()) {
                if (trialDiseases.getDisease().getId() == id) {
                    result.add(trial);
                }
            }
        }
        transaction.commit();
        session.close();
        return result;
    }

}
