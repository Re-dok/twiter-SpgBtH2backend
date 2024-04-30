package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
//import java.util.int;

@Repository
public class UserDAO implements UserDA0 {

    public final UserRepo userRepository;
    int baseUserId=1;
    @Autowired
    public UserDAO(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public int addUser(int userId, String email, String name, String password) {
        // Check if user already exists
        if (userRepository.findByEmail(email).isPresent())
            return 1; // User already exists
        userId=baseUserId;
        baseUserId++;
        // Create and save the user
        User user = new User(userId,email, name, password);
        userRepository.save(user);
        return 0; // New user added
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public Optional<List<User>> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty())
            return Optional.of(Collections.emptyList());
        return Optional.of(allUsers);
    }
}
