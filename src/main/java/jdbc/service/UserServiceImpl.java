package jdbc.service;

import jdbc.entity.User;
import jdbc.repository.UserRepository;
import jdbc.repository.UserRepositoryImplWithHib;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void createUser(User user) {
        UserRepository userRepository = new UserRepositoryImplWithHib();
        userRepository.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        UserRepository userRepository = new UserRepositoryImplWithHib();
        return userRepository.selectAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        UserRepository userRepository = new UserRepositoryImplWithHib();
        return userRepository.findUserById(id);
    }

    @Override
    public void updateUserAge(Integer id, Integer age) {
        UserRepository userRepository = new UserRepositoryImplWithHib();
        userRepository.updateUserAge(id, age);
    }

    @Override
    public void deleteUserById(Integer id) {
        UserRepository userRepository = new UserRepositoryImplWithHib();
        userRepository.deleteUserById(id);
    }

}
