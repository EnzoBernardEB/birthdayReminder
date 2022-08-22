package com.heroku.birthdayreminder.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "userApp")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy="user")
    private Set<Birthdate> birthdays;

    public User() {
        super();
    }

    public Set<Birthdate> getBirthdays() {
        return birthdays;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}