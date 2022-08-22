package com.heroku.birthdayreminder.repository;

import com.heroku.birthdayreminder.model.Birthdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BirthdateRepository extends JpaRepository<Birthdate,Long> {
    Optional<List<Birthdate>> findByUserId(Long userId);

}
