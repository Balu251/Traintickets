package com.example.UserService.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.dto.LoginDTO;
import com.example.UserService.dto.UserDTO;
import com.example.UserService.entity.User;
import com.example.UserService.exception.UserException;
import com.example.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(User user) {
    	
    
    	 Optional<User> response = userRepository.findByEmail(user.getEmail());
    	 
    	 if(response.isPresent()) {
    		 throw new UserException("Service.USER_ALREADY_EXISTS_WITH_EMAIL");
    	 }
    	 
    	 response=userRepository.findByUsername(user.getUsername());
    	 
    	 if(response.isPresent()) {
    		 throw new UserException("Service.USER_ALREADY_EXIST_WITH_USER_NAME");
    	 }
    	 
         user=userRepository.save(user);
        
        return UserDTO.mapToUserDTO(user);
    }

    @Override
    public UserDTO getUserById(String id) {
    	
    	Optional<User> response = userRepository.findById(id);
    	
    	if(response.isEmpty()) { 
    		throw new UserException("Service.USER_DOES_NOT_EXIST");
    		}
    	
    	User user = response.get();
    	
    	return UserDTO.mapToUserDTO(user);
    	
       
    }

    @Override
    public UserDTO getUserByUsername(String username) {
    	
        Optional<User> response = userRepository.findByUsername(username);
    	
    	if(response.isEmpty()) { 
    		throw new UserException("Service.USER_DOES_NOT_EXIST");
    		}
    	
    	User user = response.get();
    	
    	return UserDTO.mapToUserDTO(user);
        
    	
    	
    }

    @Override
    public String deleteUser(String id) {
    	
        if (!userRepository.existsById(id)) {
            throw new UserException("User not found with ID: " + id);
        }
        
        userRepository.deleteById(id);
        
        return "User deleted with the id "+id;
        
    }
    
    
    public boolean validateLogin(LoginDTO loginDTO) {
    	
    	Optional<User> response = userRepository.findByEmail(loginDTO.getEmail());
    	
    	if(response.isEmpty()) {
    		throw new UserException("Service.USER_ALREADY_EXISTS_WITH_EMAIL");
    	}
    	
    	User user = response.get();
    	
    	if(loginDTO.getPassword().equals(user.getPassword())) {
    		return true;
    	}

    	return false;
    }

    
}
