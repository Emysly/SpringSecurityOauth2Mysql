package com.emysilva.springsecurityoauth2mysql.repository;

import com.emysilva.springsecurityoauth2mysql.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
