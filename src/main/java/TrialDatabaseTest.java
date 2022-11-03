import controller.HibernateController;
import model.Trial;
import model.Trialtest;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TrialDatabaseTest {
    public static void main(String[] args) {

        controller.HibernateController hibernateController = controller.HibernateController.getInstance();

        SessionFactory sessionFactory = HibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Trial trial = new Trial();
        System.out.println("UserID before commit: " + trial.getId());
        trial.setTrialname("Novo Nordisk");
       // session.persist(trial);

        transaction.commit();
        System.out.println("UserID after commit: " + trial.getId());
        //Transaction readTransaction = session.beginTransaction();
        //Trial readTrial = session.get(Trial.class, trial.getId());
        //System.out.println("Read user back: " + readTrial.toString());
        List<Trial> users = session.createQuery("FROM Trial", Trial.class).list();
        System.out.println("Users in database: " + users.toString());
        //List<Trial> trials = session.createQuery("FROM Trial", Trial.class).list();
       // System.out.println("Trials in database: " + trials.toString());
       // readTransaction.commit();
        session.close();

    }

}
