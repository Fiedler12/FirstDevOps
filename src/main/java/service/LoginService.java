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

        User user = session.createQuery("from User where email = :email", User.class)
                .setParameter("email", login.getEmail())
                .uniqueResult();
        System.out.println(user);

        LoginData logindata = new LoginData();
        logindata.setEmail(user.getEmail());
        logindata.setPassword(user.getPassword());
        System.out.println(logindata);

        if (login!=null && login.equals(logindata) ){
            return JWTHandler.generateJwtToken(new User(login.getEmail(), ""));
        }
        throw new NotAuthorizedException("forkert brugernavn/kodeord");
    }
    @POST
    @Path("tokentest")
    public User postToken(String token){
        User validate = JWTHandler.validate(token);
        return validate;
    }

}



