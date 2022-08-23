package com.heroku.birthdayreminder.service;

import com.heroku.birthdayreminder.model.Birthdate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BirthdateService {
    public List<Birthdate> getAllBirthdays();
    public List<Birthdate> getBirthdaysByUserId(UUID userId);
    public Birthdate save(Birthdate birthday);
}
