package app.CRUD_SpringBoot.userDao;

import app.CRUD_SpringBoot.model.User;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

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
