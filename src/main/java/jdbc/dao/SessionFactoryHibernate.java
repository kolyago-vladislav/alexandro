package jdbc.dao;

import jdbc.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHibernate {
    public static SessionFactory sessionFactory () {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class); // где правильнее указывать? Здесь или в настройках в hibernate.cfg.xml?
        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(sBuilder.build());
    }
}