package com.heroku.birthdayreminder.repository;

import com.heroku.birthdayreminder.model.Birthdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BirthdateRepository extends JpaRepository<Birthdate, UUID> {
    Optional<List<Birthdate>> findByUserId(UUID userId);

}
