package com.valiadation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        logger.info("Fetching all users from database");
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with id: {}", id);
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        logger.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }
}

