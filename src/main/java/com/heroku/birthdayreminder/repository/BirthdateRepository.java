package com.heroku.birthdayreminder.repository;

import com.heroku.birthdayreminder.model.Birthdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BirthdateRepository extends JpaRepository<Birthdate,Long> {
    Optional<List<Birthdate>> findByUserId(Long userId);

}
