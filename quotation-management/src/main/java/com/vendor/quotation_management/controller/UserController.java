package com.vendor.quotation_management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vendor.quotation_management.entity.User;
import com.vendor.quotation_management.repository.UserRepository;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/user/{id}")
    public Object getUserById(@PathVariable Long id) {
        User user = repo.findById(id).orElse(null);
        if (user == null) {
            return "User Not Found";
        }
        logger.info("User found: {}", user);
        return user;
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        logger.info("User Saved Successfully: {}", user);
        return repo.save(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return "User Not Found";
        }
        repo.deleteById(id);
        logger.info("User deleted successfully with id: {}", id);
        return "User deleted successfully";
    }

    @PutMapping("/updateuser/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        if (!repo.existsById(id)) {
            return "User not found";
        }
        user.setUserId(id);
        repo.save(user);
        logger.info("User updated successfully: {}", user);
        return "User updated successfully";
    }
}
