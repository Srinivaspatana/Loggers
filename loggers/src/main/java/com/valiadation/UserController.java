package com.valiadation;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info("Fetching user with id: {}", id);
        return userService.getUserById(id)
                .orElseThrow(() -> {
                    logger.error("User not found with id: {}", id);
                    return new RuntimeException("User not found with id: " + id);
                });
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Creating user: {}", user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with id: {}", id);
        userService.deleteUser(id);
    }
}

