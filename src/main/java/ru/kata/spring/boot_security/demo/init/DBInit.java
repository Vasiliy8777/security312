package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DBInit {
    private UserService userService;
    private RoleServiceImpl roleService;

    @Autowired
    public DBInit(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void run() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

//        List<Role> roleList = new ArrayList<>();
//        roleList.add(adminRole);
//        roleList.add(userRole);

        roleService.addRole(adminRole);
        roleService.addRole(userRole);

        userService.addUser(new User("Luka","Lukin",26,"lukam@rmcf.com","kaktus","$2y$10$jioNBEtYUOMC5VO7MqVDxeqr0QqOYUpPRFOc.4Y6xci1g6hkkIJcW",List.of(adminRole)));
        userService.addUser(new User("Lukas", "Modric", 36,"lukasm@rmcf.com", "piktus","$2y$10$7v.bJStQJAuXMVZbt4hcruGbGXKRw.xZU5uy/9J.gLyZkOFM4kwa6", List.of(userRole)));

        userService.addUser(new User("Marcelo", "Vieira", 1988,
                "marcelo@rmcf.com", "Marcelo","$2y$10$7v.bJStQJAuXMVZbt4hcruGbGXKRw.xZU5uy/9J.gLyZkOFM4kwa6", List.of(userRole)));

        userService.addUser(new User("Karim", "Benzema", 1987,
                "kb9@rmcf.com","Karim", "$2y$10$7v.bJStQJAuXMVZbt4hcruGbGXKRw.xZU5uy/9J.gLyZkOFM4kwa6", List.of(userRole)));

        userService.addUser(new User("Sergio", "Ramos", 1986,
                "sergior@rmcf.com","Sergio", "$2y$10$jioNBEtYUOMC5VO7MqVDxeqr0QqOYUpPRFOc.4Y6xci1g6hkkIJcW", List.of(adminRole)));
    }
}
