package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Trial;
import model.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("company")
public class CompanyService {
    //TODO: replace with real database
    controller.HibernateController hibernateController = controller.HibernateController.getInstance();
    @GET
    public List<Company> getCompanies(){
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        List<Company> company = session.createQuery("from Company", Company.class).list();
        System.out.println(company);
        transaction.commit();
        session.close();
        return company;
    }

    @GET
    @Path("/{id}")
    public Company getCompany(@PathParam("id") int id){
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // get the trial from the database with hibernate
        Company company = session.get(Company.class, id);
        System.out.println(company);
        transaction.commit();
        session.close();
        return company;
    }

}
