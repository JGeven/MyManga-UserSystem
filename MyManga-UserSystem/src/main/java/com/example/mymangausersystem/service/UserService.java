package com.example.mymangausersystem.service;

import com.example.mymangausersystem.model.User;
import com.example.mymangausersystem.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    // Get all users (currently for testing purposes)
    List<User> getAllUsers();

    // Get user by userID
    User getUserByID(Long userID);

    // Save a user in the database
    User saveUser(UserDTO userDTO);
}
