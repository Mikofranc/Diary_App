package org.example.data.repository;

import org.example.data.model.User;
import org.example.dto.LoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'username':  ?0, 'password': ?1}")
    Optional<User> checkIfUserIsRegistered(String username, String password);
}
