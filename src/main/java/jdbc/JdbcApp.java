package jdbc;

import jdbc.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

    }
}