package service;

import controller.HibernateController;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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

}
