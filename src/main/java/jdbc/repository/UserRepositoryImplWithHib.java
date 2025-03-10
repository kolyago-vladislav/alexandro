package jdbc.repository;

import jdbc.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

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
    public User findUserById(int id) {
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
    public void updateUserAge(int id, int age) {
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
    public void deleteUserById(int id) {
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