package ru.kata.spring.boot_security.demo.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "Name should not be empty")
    @Size(max = 50, message = "Name is too long")
    @Size(min = 2, message = "Name is too short")
    private String name;
    @Column
    @NotBlank(message = "Surname should not be empty")
    @Size(max = 50, message = "Surname is too long")
    @Size(min = 2, message = "Surname is too short")
    private String surname;
    @Column
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @Column
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    private String email;
    @NotNull(message = "Please enter your email")
    @Column(name = "login", unique = true)
    private String login;

    @NotNull(message = "Please enter your password")
    @Column(name = "password")
    private String password;
    @ManyToMany
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User() {
    }

    public User(String name, String surname, int age, String email, String login, String password, List<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
