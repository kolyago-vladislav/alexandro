package jdbc.repository;

import jdbc.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImplWithHib implements UserRepository {

    @Override
    public void createUser(User user) {
        try(
                Session newSession = HibernateFactory.createNewSession().openSession()
                ) {
            Transaction transaction = newSession.beginTransaction();
            newSession.persist(user);
            transaction.commit();
        }

    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try(
                Session newSession = HibernateFactory.createNewSession().openSession()
        ) {
            Transaction transaction = newSession.beginTransaction();
            userList = newSession.createQuery("FROM User", User.class).getResultList();
            transaction.commit();
        }
        return userList;
    }

    @Override
    public User findUserById(Integer id) {
        User user = new User();
        try(
                Session newSession = HibernateFactory.createNewSession().openSession()
        ) {
            Transaction transaction = newSession.beginTransaction();
            user = newSession.get(User.class, id);
            transaction.commit();
        }
        return user;
    }

    @Override
    public void updateUserAge(Integer id, Integer age) {
        try(
                Session newSession = HibernateFactory.createNewSession().openSession()
        ) {
            Transaction transaction = newSession.beginTransaction();
            User user = newSession.get(User.class, id);
            user.setAge(age);
            transaction.commit();
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try(
                Session newSession = HibernateFactory.createNewSession().openSession()
        ) {
            Transaction transaction = newSession.beginTransaction();
            User user = newSession.get(User.class, id);
            newSession.remove(user);
            transaction.commit();
        }
    }
}