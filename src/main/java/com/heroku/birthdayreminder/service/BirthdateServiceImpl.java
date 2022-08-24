package com.heroku.birthdayreminder.service;

import com.heroku.birthdayreminder.model.Birthdate;
import com.heroku.birthdayreminder.repository.BirthdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BirthdateServiceImpl implements BirthdateService{
    @Autowired
    private BirthdateRepository birthdateRepository;

    public BirthdateRepository getBirthdateRepository() {
        return birthdateRepository;
    }

    @Override
    public List<Birthdate> getAllBirthdays() {
        List<Birthdate> result = birthdateRepository.findAll();

        return result;
    }

    @Override
    public List<Birthdate> getBirthdaysByUserId(UUID userId) {
        Optional<List<Birthdate>> result = birthdateRepository.findByUserId(userId);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
    public void deleteBirthdate(Birthdate birthdate) {
        birthdateRepository.delete(birthdate);
    }

    @Override
    public Birthdate save(Birthdate birthday) {
        Birthdate result = birthdateRepository.save(birthday);
        return result;
    }

    @Override
    public Birthdate findBirthdateById(UUID birthdateId) {
        Optional<Birthdate> result = birthdateRepository.findById(birthdateId);

        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
