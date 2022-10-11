package com.example.mymangausersystem.service.impl;

import com.example.mymangausersystem.exception.ResourceNotFoundException;
import com.example.mymangausersystem.model.Role;
import com.example.mymangausersystem.model.User;
import com.example.mymangausersystem.repository.UserRepository;
import com.example.mymangausersystem.service.UserService;
import com.example.mymangausersystem.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    // Get all users (currently for testing purposes)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    // Get user by userID
    public User getUserByID(Long userID) {
        User user =userRepository.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with id:" + userID));
        return user;
    }

    @Override
    // Save a user in the database
    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.getEmail(),
                userDTO.getPassword(), List.of(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
