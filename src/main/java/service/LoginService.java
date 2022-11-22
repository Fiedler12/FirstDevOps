package service;

import controller.JWTHandler;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.LoginData;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;


@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginService {
    controller.HibernateController hibernateController = controller.HibernateController.getInstance();
    @POST
    public String postLoginData(LoginData login) throws NotAuthorizedException
    {
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        LoginData logindata;
        User user;
        try {
            user = session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", login.getEmail())
                    .uniqueResult();
            System.out.println(user);
            logindata = new LoginData();
            logindata.setEmail(user.getEmail());
            logindata.setPassword(user.getPassword());
            System.out.println(logindata);
        }catch (Exception e) {
            transaction.commit();
            session.close();
            throw new NotAuthorizedException("User not found");
        }

        if (login!=null && login.getEmail().equals(logindata.getEmail()) && BCrypt.checkpw(login.getPassword(), logindata.getPassword())) {
            transaction.commit();
            session.close();
            return JWTHandler.generateJwtToken(new User(user.getId(), login.getEmail(), ""));
        }
        transaction.commit();
        session.close();
        throw new NotAuthorizedException("forkert brugernavn/kodeord");
    }

}



