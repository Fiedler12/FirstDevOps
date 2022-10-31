package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.JpaCriteriaQuery;


import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("users")
public class UserEndpoint {

    private static final SessionFactory sessionFactory = new HibernateController("probe.diplomportal.dk:5432/devops").getSessionFactory();

    @POST
    public int createUser(User user){
        Session session = sessionFactory.openSession();
        session.persist(user);
        return user.getId();
    }
    @GET
    public List<User> getUsers(){
        Session session = sessionFactory.openSession();
        JpaCriteriaQuery<User> query = session.getCriteriaBuilder().createQuery(User.class);
        query.from(User.class);
        List<User> data = session.createQuery(query).getResultList();
        return data;
    }

}
