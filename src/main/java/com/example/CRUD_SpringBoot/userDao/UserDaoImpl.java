package com.example.CRUD_SpringBoot.userDao;


import com.example.CRUD_SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }


    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
