package service;

import controller.HibernateController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.core.MediaType;
import model.Disease;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("disease")
public class DiseaseService {

    controller.HibernateController hibernateController = controller.HibernateController.getInstance();

    @GET
    public List<Disease> getDiseases() throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Disease>diseases = session.createQuery("from Disease", Disease.class).list();
            transaction.commit();
            session.close();
            return diseases;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("Disease not found");
        }
    }

    @POST
    @Path("/init")
    public void init() {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{;
            Disease disease = new Disease();
            disease.setName("Alzheimer");
            session.persist(disease);
            Disease disease1 = new Disease();
            disease1.setName("Parkinson");
            session.persist(disease1);
            Disease disease3 = new Disease();
            disease.setName("ALS");
            session.persist(disease3);
            Disease disease4 = new Disease();
            disease.setName("Hemorrhoids");
            session.persist(disease4);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }

}
