package com.heroku.birthdayreminder.repository;

import com.heroku.birthdayreminder.model.Birthdate;
import com.heroku.birthdayreminder.model.ERole;
import com.heroku.birthdayreminder.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

}