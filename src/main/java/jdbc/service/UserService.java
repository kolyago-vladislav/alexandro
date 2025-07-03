package jdbc.service;

import jdbc.entity.User;
import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUserAge(User user); // update User age

    void deleteUserById(Long id);
}
