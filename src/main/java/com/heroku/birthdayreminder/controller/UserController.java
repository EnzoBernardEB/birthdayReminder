package com.heroku.birthdayreminder.controller;

import com.heroku.birthdayreminder.model.User;
import com.heroku.birthdayreminder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController
{
    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @GetMapping(value = { "", "/" })
    public List<User> getUsers() {
        List<User> result = userService.getAllUsers();

        return result;
    }
}
