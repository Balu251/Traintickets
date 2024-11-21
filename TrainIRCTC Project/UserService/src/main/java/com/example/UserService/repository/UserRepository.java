package com.example.UserService.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.UserService.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
