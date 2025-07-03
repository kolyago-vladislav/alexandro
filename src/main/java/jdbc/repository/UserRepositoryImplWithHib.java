package jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jdbc.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepositoryImplWithHib implements UserRepository {

    private EntityManagerFactory entityManagerFactory;

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void createUser(User user) {
        try(
                EntityManager entityManager = this.entityManagerFactory.createEntityManager();
                ) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }

    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList;
        try(
                EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        ) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            userList = entityManager.createQuery("FROM User", User.class).getResultList();
            transaction.commit();
        }
        return userList;
    }

    @Override
    public User findUserById(Integer id) {
        User user;
        try(
                EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        ) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            user = entityManager.find(User.class, id);
            transaction.commit();
        }
        return user;
    }

    @Override
    public void updateUserAge(Integer id, Integer age) {
        try(
                EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        ) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            User user = entityManager.find(User.class, id);
            user.setAge(age);
            transaction.commit();
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try(
                EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        ) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            transaction.commit();
        }
    }
}