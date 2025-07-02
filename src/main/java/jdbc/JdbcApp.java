package jdbc;

import jakarta.persistence.EntityManagerFactory;
import jdbc.config.JavaConfig;
import jdbc.model.User;
import jdbc.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);

        User user = (User) context.getBean(User.class);
        user.setName("Alexander");
        user.setSurname("Pilipuchka");
        user.setAge(24);
        user.setUsername("Klaid");
        user.setPassword("lsdkgnslkdn");

        UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");
        userService.createUser(user);

    }
}