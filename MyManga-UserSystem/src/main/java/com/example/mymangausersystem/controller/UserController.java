package com.example.mymangausersystem.controller;

import com.example.mymangausersystem.model.User;
import com.example.mymangausersystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users (Currently for testing purposes)
    // Later Postmapping Register
    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User dbUser = userService.registerUser(user);
        return ResponseEntity.ok(dbUser);
    }

    // login
    @GetMapping("/users")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User dbUser = userService.loginUser(user.getEmail(),user.getPassword());
        return ResponseEntity.ok(dbUser);
    }

    // Delete user from database
    @DeleteMapping("/users")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // Update user from database
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestParam Long id, @RequestBody User user) {
        User dbUser = userService.updateUser(id,user);
        return ResponseEntity.ok(dbUser);
    }
}
