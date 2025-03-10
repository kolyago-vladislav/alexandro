package jdbc.repository;

import jdbc.entity.User;
import java.util.List;

public interface UserRepository {
    void createUser(User user);
    List<User> selectAllUsers();
    User findUserById(Integer id);
    void updateUserAge(Integer id, Integer age); // update User age
    void deleteUserById(Integer id);
}
