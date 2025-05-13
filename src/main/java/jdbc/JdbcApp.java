package jdbc;

import jdbc.entity.User;
import jdbc.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcApp {
    public static void main(String[] args) {
        System.out.println("sasha pilipucha is a good man but the worst java developer");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        context.getBean("user", User.class);
    }
}