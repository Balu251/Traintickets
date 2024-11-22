package com.example.UserService.dto;

import com.example.UserService.entity.User;

public class UserDTO {

    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String fullName;
    private String gender;
    private String address;

    // Constructors
    public UserDTO() {}

    public UserDTO(String id, String username, String email, String phoneNumber, String fullName, String gender, String address) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    // Getters and Setters
	
	public static UserDTO mapToUserDTO(User user) {
		
		UserDTO userDTO=new UserDTO();
		
		userDTO.setAddress(user.getAddress());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setFullName(user.getFullName());
		userDTO.setGender(user.getGender());
		userDTO.setId(user.getId());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setUsername(user.getUsername());
		
		return userDTO;
		
		
	}
	
	public static User mapToUser(UserDTO userDTO) {
		
		User user=new User();
		
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setFullName(userDTO.getFullName());
		user.setGender(userDTO.getGender());
		user.setId(userDTO.getId());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setUsername(userDTO.getUsername());
		
		return user;
	}
    
}
