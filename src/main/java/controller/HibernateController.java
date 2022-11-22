
package controller;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateController {//Should be a singleton…
    private static HibernateController instance = null;
    private static SessionFactory sessionFactory;
    private String dbUrl = "probe.diplomportal.dk:5432/devops";

    private HibernateController(){
        Configuration configuration = new Configuration();//NB org.hibernate.cfg.Configuration
        configuration.addAnnotatedClass(Disease.class);
        configuration.addAnnotatedClass(User.class); //remember to do this for all DB entities
        configuration.addAnnotatedClass(Trial.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Subscribe.class);
        configuration.addAnnotatedClass(TrialDiseases.class);
        configuration.addAnnotatedClass(UserDiseases.class);
        configuration.setProperty("hibernate.connection.username", System.getenv("devopse22user"));
        configuration.setProperty("hibernate.connection.password", System.getenv("devopse22pass"));
        //configuration.setProperty("hibernate.default_schema","dev");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://" + dbUrl);
        configuration.setProperty("hibernate.hbm2ddl.auto","update"); //update Schema - don't do this in prod
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateController getInstance(){
        if (instance == null){
            instance = new HibernateController();
        }
        return instance;
    }
    public synchronized static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
