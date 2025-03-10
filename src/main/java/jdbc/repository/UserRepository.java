package jdbc.repository;

import jdbc.entity.User;
import java.util.List;

public interface UserRepository {
    void createUser(User user);
    List<User> selectAllUsers();
    User findUserById(int id);
    void updateUserAge(int id, int age); // update User age
    void deleteUserById(int id);
}
