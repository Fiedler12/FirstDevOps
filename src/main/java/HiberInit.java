import controller.HibernateController;
import model.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HiberInit {
    public void init() {
        HibernateController hibernateController = HibernateController.getInstance();
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            List<Company> companies = session.createQuery("from Company", Company.class).list();
            Company company = new Company();
            company.setCompanyName("Test");
            company.setEmail("test@popo.com");
            companies.add(company);
            Company company1 = new Company();
            company1.setCompanyName("Test2");
            company1.setEmail("test@Trans.com");
            companies.add(company1);
            session.persist(companies);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }
}

