package service;

import controller.JWTHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Trial;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("users")
public class UsersService {
    //TODO: replace with real database
    controller.HibernateController hibernateController = controller.HibernateController.getInstance();

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id, @HeaderParam("Authorization") String authHeader) throws NotAuthorizedException {
        User auth = JWTHandler.validate(authHeader);
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        User user = session.get(User.class, id);
        System.out.println(user);
        // check if the user is the same as the one in the token
        if (auth.getId() == user.getId()){
            transaction.commit();
            session.close();
            return user;
        } else {
            transaction.commit();
            session.close();
            throw new NotAuthorizedException("User not authorized");
        }
    }
    // http put request to update a user in the database with the id from the path parameter and the user from the request body (json) and the token from the header parameter (json)
    @PUT
    @Path("/{id}")
    public User putUser(@PathParam("id") int id, User user, @HeaderParam("Authorization") String authHeader) throws NotAuthorizedException {
        User auth = JWTHandler.validate(authHeader);
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        User userDB = session.get(User.class, id);
        System.out.println(userDB);
        // check if the user is the same as the one in the token
        if (auth.getId() == userDB.getId()){
            userDB.setName(user.getName());
            userDB.setEmail(user.getEmail());
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
            userDB.setSalt(salt);
            userDB.setPassword(hashedPassword);
            // session.persist(userDB);
            session.merge(userDB);
            transaction.commit();
            session.close();
            return userDB; // maybe remove this later
        } else {
            transaction.commit();
            session.close();
            throw new NotAuthorizedException("User not authorized");
        }
    }

    //Does Not wotk yet
    @POST
    @Path("/register")
    public User postUser(User user) throws NotAuthorizedException {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User userDB;
        try {
            userDB = session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", user.getEmail())
                    .uniqueResult();
            System.out.println(userDB);
        }catch (Exception e) {
            transaction.commit();
            session.close();
            throw new NotAuthorizedException("User not found");
        }
        if (userDB != null){
            transaction.commit();
            session.close();
            throw new NotAuthorizedException("User already exists");
        } else {
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
            System.out.println(user);
            user.setSalt(salt);
            user.setPassword(hashedPassword);
            System.out.println(user);
            session.persist(user);
            System.out.println(user);
            transaction.commit();
            session.close();
            return user;
        }
    }
}