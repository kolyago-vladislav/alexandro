package jdbc.service;

import jdbc.entity.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    void updateUserAge(Integer id, Integer age); // update User age

    void deleteUserById(Integer id);
}
