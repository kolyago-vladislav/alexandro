package jdbc;

import jdbc.dao.UserRepositoryHibImpl;
import jdbc.entity.User;

public class JdbcApp {
    public static void main(String[] args) {
//        User user1 = new User();
//        user1.setName("Veronica");
//        user1.setSurname("Piun");
//        user1.setUsername("Veronichka");
//        user1.setPassword("Vis");
//        user1.setAge(22);
        UserRepositoryHibImpl userDao = new UserRepositoryHibImpl();
        System.out.println(userDao.selectAllUsers());
    }
}