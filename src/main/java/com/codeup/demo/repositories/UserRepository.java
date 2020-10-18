package com.codeup.demo.repositories;

import com.codeup.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    // Need to be able to search for user by username, as in Integration Tests
    User findByUsername(String username);
}
