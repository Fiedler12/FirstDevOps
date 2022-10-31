package service;

        import jakarta.ws.rs.GET;
        import jakarta.ws.rs.POST;
        import jakarta.ws.rs.Path;
        import jakarta.ws.rs.Produces;
        import jakarta.ws.rs.core.MediaType;
        import model.Trial;
        import model.User;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.query.criteria.JpaCriteriaQuery;


        import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("trials")
public class TrialEndpoint {

    private static final SessionFactory sessionFactory = new HibernateController("probe.diplomportal.dk:5432/devops").getSessionFactory();

    @POST
    public int createTrial(Trial trial){
        Session session = sessionFactory.openSession();
        session.persist(trial);
        return trial.getId();
    }
    @GET
    public List<Trial> getTrials(){
        Session session = sessionFactory.openSession();
        JpaCriteriaQuery<Trial> query = session.getCriteriaBuilder().createQuery(Trial.class);
        query.from(Trial.class);
        List<Trial> data = session.createQuery(query).getResultList();
        return data;
    }

}
