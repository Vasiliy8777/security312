package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserServ {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User updatedUser);

    User getUserById(Long id);
    User findUserByLogin(String login);

    void deleteUser(Long id);
}

