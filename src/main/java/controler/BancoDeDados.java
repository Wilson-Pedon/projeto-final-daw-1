package controler;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BancoDeDados {


    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    public static EntityManager em = emf.createEntityManager();
    public static SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
    public static Session session = sessionFactory.openSession();
    public static StringBuilder jpql = new StringBuilder();


}
