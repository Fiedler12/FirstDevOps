package service;

import controller.HibernateController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Company;
import model.Disease;
import model.Trial;
import model.User;
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
    @DELETE
    public void deleteTrial(Trial trial) throws NotAuthorizedException {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.remove(trial);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Trial not deleted");
        }
    }

    @POST
    @Path("/subscribe/{trialID}/{userId}")
    public int subscribe(@PathParam("trialID") int trialId, @PathParam("userId") int userId) throws NotAuthorizedException {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userId);
            Trial trial = session.get(Trial.class, trialId);
            if (!user.getSubscriptions().contains(trial)) {
                user.addSubscription(trial);
                transaction.commit();
                session.close();
                return 200;
            } else {
                transaction.rollback();
                session.close();
                throw new NotAuthorizedException("User already subscribed");
            }
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("could not subscribe");
        }
    }

    @GET
    @Path("/disease/{id}")
    public List<Trial> getDiseaseSpecific(@PathParam("id") int id) throws NotAuthorizedException {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Trial> trials = session.createQuery("from Trial", Trial.class).list();
            List<Trial> result = new ArrayList<>();
            for (Trial trial: trials
                 ) {
                for(Disease disease: trial.getDiseases()) {
                    if (disease.getId() == id)  {
                        result.add(trial);
                    }
                }
            }
            transaction.commit();
            session.close();
            return result;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Could not get.");
        }
    }

    @DELETE
    @Path("/unsubscribe/{trialID}/{userId}")
    public int unsubscribe(@PathParam("trialID") int trialId, @PathParam("userId") int userId) throws NotAuthorizedException {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userId);
            Trial trial = session.get(Trial.class, trialId);
            if (user.getSubscriptions().contains(trial)) {
                user.removeSubscription(trial);
                transaction.commit();
                session.close();
                return 200;
            } else {
                transaction.rollback();
                session.close();
                throw new NotAuthorizedException("User not subscribed");
            }
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("could not unsubscribe");
        }
    }
    @GET
    @Path("/isSubscribed/{trialId}/{userId}")
    public boolean isSubscribed(@PathParam("trialId") int trialId, @PathParam("userId") int userId) throws NotAuthorizedException {
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userId);
            Trial trial = session.get(Trial.class, trialId);
            if (user.getSubscriptions().contains(trial)) {
                transaction.commit();
                session.close();
                return true;
            } else {
                transaction.rollback();
                session.close();
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("could not check subscription");
        }
    }

}
