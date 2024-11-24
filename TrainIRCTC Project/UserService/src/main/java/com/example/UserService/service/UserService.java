package com.example.UserService.service;


import com.example.UserService.dto.LoginDTO;
import com.example.UserService.dto.UserDTO;
import com.example.UserService.entity.User;

public interface UserService {
	
    public UserDTO createUser(User user);
    public UserDTO getUserById(String id);
    public UserDTO getUserByUsername(String username);
    public String deleteUser(String id);
    public boolean validateLogin(LoginDTO loginDTO);
    
    
    
}
