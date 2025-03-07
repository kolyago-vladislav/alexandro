package jdbc.dao;

import jdbc.entity.User;
import java.util.List;

public interface UserRepositoryHib {
    void createUser(User user);
    List<User> selectAllUsers();
    User findUserById(int id);
    void updateUsers(User user); //change the age of user by the ID
    void deleteUserById(int id);
}
