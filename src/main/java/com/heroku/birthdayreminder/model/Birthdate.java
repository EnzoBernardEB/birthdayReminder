package com.heroku.birthdayreminder.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Birthdate {
    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;
    private String firstname;
    private String lastname;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Birthdate() {
        super();
    }


    public UUID getId() {
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