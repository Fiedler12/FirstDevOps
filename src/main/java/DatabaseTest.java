import model.Trial;
import model.Trialtest;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseTest {
    public static void main(String[] args) {

        controller.HibernateController hibernateController = controller.HibernateController.getInstance();

        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        System.out.println("UserID before commit: " + user.getId());
        user.setName("Hans Christian");
        session.persist(user);

        transaction.commit();
        System.out.println("UserID after commit: " + user.getId());
        Transaction readTransaction = session.beginTransaction();
        User readUser = session.get(User.class, user.getId());
        System.out.println("Read user back: " + readUser.toString());
        List<User> users = session.createQuery("FROM User", User.class).list();
        System.out.println("Users in database: " + users.toString());
        List<Trialtest> trials = session.createQuery("FROM Trialtest", Trialtest.class).list();
        System.out.println("Trials in database: " + trials.toString());
        readTransaction.commit();
        session.close();

    }

}
