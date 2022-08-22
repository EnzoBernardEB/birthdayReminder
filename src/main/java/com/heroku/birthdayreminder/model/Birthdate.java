package com.heroku.birthdayreminder.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Birthdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Birthdate() {
        super();
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Birthdate{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}