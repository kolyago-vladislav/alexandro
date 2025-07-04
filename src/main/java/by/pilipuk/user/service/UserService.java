package by.pilipuk.user.service;

import by.pilipuk.user.entity.User;
import by.pilipuk.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public void updateUser(Long id, User user) {
        User user1 = this.userRepository.findById(id).orElse(null);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setAge(user.getAge());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        this.userRepository.save(user1);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

}