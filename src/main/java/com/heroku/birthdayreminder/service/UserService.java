package com.heroku.birthdayreminder.service;

import com.heroku.birthdayreminder.model.User;
import com.heroku.birthdayreminder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    public User login(String username, String password);
    public List<User> getAllUsers();
    public User save(User user);
}
