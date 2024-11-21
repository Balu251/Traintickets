package com.example.UserService.service;


import java.util.Optional;

import com.example.UserService.dto.UserDTO;
import com.example.UserService.entity.User;

public interface UserService {
    User createUser(User user);
    Optional<UserDTO> getUserById(String id);
    Optional<UserDTO> getUserByUsername(String username);
    void deleteUser(String id);
}
