package com.example.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.dto.LoginDTO;
import com.example.UserService.dto.UserDTO;
import com.example.UserService.entity.User;
import com.example.UserService.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
    	
    	 UserDTO userDTO = userService.createUser(user);
    	
    	return new ResponseEntity<UserDTO>(userDTO,HttpStatus.CREATED);
    	
    }
    
    public ResponseEntity<Boolean> login(@RequestBody LoginDTO loginDTO){
    	
    	
    	
    	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
    	
         UserDTO userDTO = userService.getUserById(id);
    	return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
        
    }
    

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
    	
    	UserDTO userDTO = userService.getUserByUsername(username);
    	
    	return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
    	
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
    	
    	String response = userService.deleteUser(id);
    	
    	return new ResponseEntity<String>(response,HttpStatus.OK);
        
    }
}
