package com.heroku.birthdayreminder.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    public Role() {
    }
    public Role(ERole name) {
        this.name = name;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public ERole getName() {
        return name;
    }
    public void setName(ERole name) {
        this.name = name;
    }
}