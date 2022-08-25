package com.heroku.birthdayreminder.security.payload.response;

import com.heroku.birthdayreminder.model.Birthdate;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private UUID id;
    private String username;
    private String email;
    private List<String> roles;
    Set<Birthdate> birthdates;
    public JwtResponse(String accessToken, String refreshToken, UUID id, String username, String email, List<String> roles, Set<Birthdate> birthdates) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.birthdates = birthdates;
    }

    public Set<Birthdate> getBirthdates() {
        return birthdates;
    }

    public void setBirthdates(Set<Birthdate> birthdates) {
        this.birthdates = birthdates;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}