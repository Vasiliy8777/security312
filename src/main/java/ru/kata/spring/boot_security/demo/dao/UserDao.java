package ru.kata.spring.boot_security.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;


@Repository
public class UserDao implements Dao {
    private final UserRepository userRepository;



    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

//    @Override
//    public void updateUser(Long id, User updatedUser) {
//        User existingUser = userRepository.findById(id).orElse(null);
//        if (existingUser != null) {
//            existingUser.setName(updatedUser.getName());
//            existingUser.setSurname(updatedUser.getSurname());
//            existingUser.setAge(updatedUser.getAge());
//            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setLogin(updatedUser.getLogin());
//            existingUser.setRoles(updatedUser.getRoles());
//            if (!existingUser.getPassword().equals(updatedUser.getPassword())) {
//                existingUser.setPassword(
//                        bCryptPasswordEncoder.encode(updatedUser.getPassword()));
//            }
//        } else {
//            throw new UsernameNotFoundException(
//                    String.format("User with id: %s not found", id));
//        }
//    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}