package jdbc.repository;

import jdbc.config.JavaConfig;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class HibernateFactory {
    public static SessionFactory createNewSession () {

            return new org.hibernate.cfg.Configuration()
                    .addProperties(JavaConfig.hibernateConfig())
                    .buildSessionFactory();
    }

}