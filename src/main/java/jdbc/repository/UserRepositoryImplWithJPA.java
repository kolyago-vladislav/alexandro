package jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jdbc.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplWithJPA implements UserRepository {

    @Override
    public void createUser(User user) {
        try(
                EntityManager newEntityManager = HibernateFactory.createNewEntityManager()
        ) {
            EntityTransaction transaction = newEntityManager.getTransaction();
            transaction.begin();
            newEntityManager.persist(user);
            transaction.commit();
        }

    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try(
                EntityManager newEntityManager = HibernateFactory.createNewEntityManager()
        ) {
            EntityTransaction transaction = newEntityManager.getTransaction();
            transaction.begin();
            userList = newEntityManager.createQuery("FROM User", User.class).getResultList();
            transaction.commit();
        }
        return userList;
    }

    @Override
    public User findUserById(Integer id) {
        User user = new User();
        try(
                EntityManager newEntityManager = HibernateFactory.createNewEntityManager()
        ) {
            EntityTransaction transaction = newEntityManager.getTransaction();
            transaction.begin();
            user = newEntityManager.find(User.class, id);
            transaction.commit();
        }
        return user;
    }

    @Override
    public void updateUserAge(Integer id, Integer age) {
        try(
                EntityManager newEntityManager = HibernateFactory.createNewEntityManager()
        ) {
            EntityTransaction transaction = newEntityManager.getTransaction();
            transaction.begin();
            User user = newEntityManager.find(User.class, id);
            user.setAge(age);
            transaction.commit();
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try(
                EntityManager newEntityManager = HibernateFactory.createNewEntityManager()
        ) {
            EntityTransaction transaction = newEntityManager.getTransaction();
            transaction.begin();
            User user = newEntityManager.find(User.class, id);
            newEntityManager.remove(user);
            transaction.commit();
        }
    }
}