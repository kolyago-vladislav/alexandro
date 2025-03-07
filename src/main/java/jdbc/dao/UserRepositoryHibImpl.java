package jdbc.dao;

import jdbc.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryHibImpl implements UserRepositoryHib {

    @Override
    public void createUser(User user) {
        try(
                Session sessionCreate = SessionFactoryHibernate.sessionFactory().openSession()
        ) {
            Transaction transaction = sessionCreate.beginTransaction();
            sessionCreate.save(user);
            transaction.commit();
        }
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> usersList = new ArrayList<>();
        try(
                Session sessionCreate = SessionFactoryHibernate.sessionFactory().openSession()
        ) {
            Transaction transaction = sessionCreate.beginTransaction();
            usersList = sessionCreate.createQuery("FROM User", User.class).getResultList();
            transaction.commit();
        }
        return usersList;
    }

    @Override
    public User findUserById(int id) {
        User user = new User();
        try(
                Session sessionCreate = SessionFactoryHibernate.sessionFactory().openSession()
        ) {
            Transaction transaction = sessionCreate.beginTransaction();
            user = sessionCreate.get(User.class,id);
            transaction.commit();
        }
        return user;
    }

    @Override
    public void updateUsers(User user) {
        try(
                Session sessionCreate = SessionFactoryHibernate.sessionFactory().openSession()
        ) {
            Transaction transaction = sessionCreate.beginTransaction();
            sessionCreate.update(user);
            transaction.commit();
        }
    }

    @Override
    public void deleteUserById(int id) {
        try(
                Session sessionCreate = SessionFactoryHibernate.sessionFactory().openSession()
        ) {
            Transaction transaction = sessionCreate.beginTransaction();
            User user = sessionCreate.get(User.class, id);
            sessionCreate.delete(user);
            transaction.commit();
        }
    }
}