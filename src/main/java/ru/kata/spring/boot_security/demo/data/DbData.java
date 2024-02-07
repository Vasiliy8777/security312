package ru.kata.spring.boot_security.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DbData {
    private UserService userService;
    private RoleServiceImpl roleService;

    @Autowired
    public DbData(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void run() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.addRole(adminRole);
        roleService.addRole(userRole);

        userService.addUser(new User("Tod", "Todes", 26, "Tod@qwer.com", "kaktus", "$2y$10$jioNBEtYUOMC5VO7MqVDxeqr0QqOYUpPRFOc.4Y6xci1g6hkkIJcW", List.of(adminRole)));
        userService.addUser(new User("Mot", "Modes", 36, "Mot@rmcf.com", "piktus", "$2y$10$7v.bJStQJAuXMVZbt4hcruGbGXKRw.xZU5uy/9J.gLyZkOFM4kwa6", List.of(userRole)));

        userService.addUser(new User("Tom", "Tomes", 88,
                "Tom@qwer.com", "TomTom", "$2y$10$7v.bJStQJAuXMVZbt4hcruGbGXKRw.xZU5uy/9J.gLyZkOFM4kwa6", List.of(userRole)));

        userService.addUser(new User("Ben", "Benas", 19,
                "Ben@qwer.com", "BeBe", "$2y$10$7v.bJStQJAuXMVZbt4hcruGbGXKRw.xZU5uy/9J.gLyZkOFM4kwa6", List.of(userRole)));

        userService.addUser(new User("Bob", "Bobas", 16,
                "Bob@qwer.com", "BoBo", "$2y$10$jioNBEtYUOMC5VO7MqVDxeqr0QqOYUpPRFOc.4Y6xci1g6hkkIJcW", List.of(adminRole)));
    }
}
