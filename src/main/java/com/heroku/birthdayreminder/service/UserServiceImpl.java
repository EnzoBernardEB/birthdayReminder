package com.heroku.birthdayreminder.service;

import com.heroku.birthdayreminder.model.User;
import com.heroku.birthdayreminder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public User login(String username, String password) {
        Optional<User> result = userRepository.findByUsernameAndPassword(username,password);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = userRepository.findAll();

        return result;

    };

    @Override
    public User save(User user){
      User result = userRepository.save(user);

      return result;
    };
    public User findUserById(UUID userId) {
        Optional<User> result = userRepository.findById(userId);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("User Unknown");
        }
    }

}
