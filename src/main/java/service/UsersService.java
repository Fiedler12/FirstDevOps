package service;

import controller.JWTHandler;
import jakarta.ws.rs.*;
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
    // code not working and not used yet
    //    @GET
    //    public List<User> getUsers(){
    //        Session session = hibernateController.getSessionFactory().openSession();
    //        Transaction transaction = session.beginTransaction();
    //
    //        // get the trial from the database with hibernate
    //        List<User> users = session.createQuery("from User", User.class).list();
    //        System.out.println(users);
    //        transaction.commit();
    //        session.close();
    //        return users;
    //    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id, @HeaderParam("Authorization") String authHeader) throws NotAuthorizedException {
        User auth = JWTHandler.validate(authHeader);
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            // get the trial from the database with hibernate
            User user = session.get(User.class, id);
            if (auth.getId() == user.getId()) {
                transaction.commit();
                session.close();
                return user;
            } else {
                throw new NotAuthorizedException("You are not authorized to view this user");
            }
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("User not found");
        }
    }

    // http put request to update a user in the database with the id from the path parameter and the user from the request body (json) and the token from the header parameter (json)
    @PUT
    @Path("/{id}")
    public User putUser(@PathParam("id") int id, User user, @HeaderParam("Authorization") String authHeader) throws NotAuthorizedException {
        User auth = JWTHandler.validate(authHeader);
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User userDB = session.get(User.class, id);
            // check if the user is the same as the one in the token
            if (auth.getId() == userDB.getId()) {
                userDB.setName(user.getName());
                userDB.setEmail(user.getEmail());
                userDB.setPassword(user.getPassword());
                session.merge(userDB);
                transaction.commit();
                session.close();
                return userDB;
            } else {
                transaction.rollback();
                session.close();
                throw new NotAuthorizedException("User not authorized");
            }
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new NotAuthorizedException("User not found");
        }

    }
}