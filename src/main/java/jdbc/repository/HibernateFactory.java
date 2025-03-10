package jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdbc.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    public static SessionFactory createNewSession () {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class); // где правильнее указывать? Здесь или в настройках в hibernate.cfg.xml?
        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(sBuilder.build());
    }

    public static EntityManager createNewEntityManager () {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}