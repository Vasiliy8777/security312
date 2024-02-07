package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface Dao {
    List<User> getAllUsers();

    User findByLogin(String login);

    void addUser(User user);

    void updateUser(User updatedUser);

    User getUserById(Long id);

    void deleteUser(Long id);
}