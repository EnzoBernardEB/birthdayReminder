package com.heroku.birthdayreminder.controller;

import com.heroku.birthdayreminder.DTO.BirthdateDTO;
import com.heroku.birthdayreminder.model.Birthdate;
import com.heroku.birthdayreminder.model.User;
import com.heroku.birthdayreminder.service.BirthdateService;
import com.heroku.birthdayreminder.service.BirthdateServiceImpl;
import com.heroku.birthdayreminder.service.UserService;
import com.heroku.birthdayreminder.service.UserServiceImpl;
import com.heroku.birthdayreminder.utils.BirthdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    UserServiceImpl userService;
    @Autowired
    BirthdateServiceImpl birthdateService;


    public UserService getUserService() {
        return userService;
    }

    public BirthdateService getBirthdateService() {
        return birthdateService;
    }

    @GetMapping(value = {"" })
    public ResponseEntity<List<User>> getUsers() {
        List<User> result = userService.getAllUsers();

        return new ResponseEntity<List<User>>(result,HttpStatus.OK);
    }

    @GetMapping(value = {"/{userId}" })
    public ResponseEntity<User> getUser(@PathVariable("userId") UUID userId) {
        User result = userService.findUserById(userId);

        return new ResponseEntity<User>(result,HttpStatus.OK);
    }

    @GetMapping(value = {"/{userId}/birthdates" })
    public ResponseEntity<List<Birthdate>> getUserBirthdates(@PathVariable("userId") UUID userId) {
        List<Birthdate> result = birthdateService.getBirthdaysByUserId(userId);

        return new ResponseEntity<List<Birthdate>>(result,HttpStatus.OK);
    }

    @PostMapping("/birthdates")
    public ResponseEntity<BirthdateDTO> addBirthdate(@RequestBody BirthdateDTO birthdateDTO) {
        Birthdate birthdateToAdd = BirthdateMapper.INSTANCE.sourceToDestination(birthdateDTO);
        birthdateToAdd.setUser(userService.findUserById(birthdateDTO.getUserId()));
        Birthdate birthdateAdded = birthdateService.save(birthdateToAdd);

        return new ResponseEntity<BirthdateDTO>(BirthdateMapper.INSTANCE.destinationToSource(birthdateAdded),HttpStatus.CREATED);
    }

    @PutMapping("/birthdates")
    public ResponseEntity<BirthdateDTO> updateBirthdate(@RequestBody BirthdateDTO birthdateDTO) {
        Birthdate birthdateToUpdate = birthdateService.findBirthdateById(birthdateDTO.getId());
        BirthdateMapper.INSTANCE.updateBirthDateFromDto(birthdateDTO,birthdateToUpdate);
        Birthdate birthdateAdded = birthdateService.save(birthdateToUpdate);

        return new ResponseEntity<BirthdateDTO>(BirthdateMapper.INSTANCE.destinationToSource(birthdateAdded), HttpStatus.OK);
    }

    @DeleteMapping("/birthdates/{birthdateId}")
    public ResponseEntity<?> deleteBirthdate(@PathVariable("birthdateId") UUID birthdateId) {
        Birthdate birthdateToDelete = birthdateService.findBirthdateById(birthdateId);
        birthdateService.deleteBirthdate(birthdateToDelete);

        return ResponseEntity.ok().build();
    }



}
