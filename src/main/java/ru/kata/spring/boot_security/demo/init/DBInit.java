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
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

//        List<Role> roleList = new ArrayList<>();
//        roleList.add(adminRole);
//        roleList.add(userRole);

        roleService.addRole(adminRole);
        roleService.addRole(userRole);

        userService.addUser(new User("Luka","Lukin",26,"lukam@rmcf.com","kaktus","admin",List.of(adminRole)));
        userService.addUser(new User("Lukas", "Modric", 36,"lukasm@rmcf.com", "piktus","user", List.of(userRole)));

        userService.addUser(new User("Marcelo", "Vieira", 1988,
                "marcelo@rmcf.com", "Marcelo","user", List.of(userRole)));

        userService.addUser(new User("Karim", "Benzema", 1987,
                "kb9@rmcf.com","Karim", "user", List.of(userRole)));

        userService.addUser(new User("Sergio", "Ramos", 1986,
                "sergior@rmcf.com","Sergio", "admin", List.of(adminRole)));
    }
}
