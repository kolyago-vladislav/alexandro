package jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.Properties;

@Configuration
@ComponentScan("jdbc")
@PropertySource(value = { "classpath:application.properties" })
public class JavaConfig {

    public static Properties hibernateConfig() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "postgres");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hbm2ddl.auto", "update");
        return prop;
    }

}