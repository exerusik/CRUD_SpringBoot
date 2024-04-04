package com.example.CRUD_SpringBoot.userDao;

import com.example.CRUD_SpringBoot.model.User;

import java.util.List;


public interface UserDao {
    List<User> getAll();

    void saveUser(User user);

    void deleteUserById(long id);

    User getUserById(long id);
}
