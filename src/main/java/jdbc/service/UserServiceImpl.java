package jdbc.service;

import jdbc.entity.User;
import jdbc.repository.UserRepositoryImplWithHib;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepositoryImplWithHib userRepositoryImplWithHib;

    public void setUserRepositoryImplWithHib(UserRepositoryImplWithHib userRepositoryImplWithHib) {
        this.userRepositoryImplWithHib = userRepositoryImplWithHib;
    }

    @Override
    public void createUser(User user) {
        this.userRepositoryImplWithHib.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepositoryImplWithHib.selectAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return this.userRepositoryImplWithHib.findUserById(id);
    }

    @Override
    public void updateUserAge(Integer id, Integer age) {
        this.userRepositoryImplWithHib.updateUserAge(id, age);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userRepositoryImplWithHib.deleteUserById(id);
    }

}
