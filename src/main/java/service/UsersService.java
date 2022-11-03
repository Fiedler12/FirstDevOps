package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Trial;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("users")
public class UsersService {
    //TODO: replace with real database
    controller.HibernateController hibernateController = controller.HibernateController.getInstance();
    @GET
    public List<User> getUsers(){
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        List<User> users = session.createQuery("from User", User.class).list();
        System.out.println(users);
        transaction.commit();
        session.close();
        return users;
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id){
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        User user = session.get(User.class, id);
        System.out.println(user);
        transaction.commit();
        session.close();
        return user;
    }

}