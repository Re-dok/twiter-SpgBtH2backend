package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.UserService;
import com.example.majorAssignment.model.User;
import com.example.majorAssignment.model.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController

@RequestMapping("/")
public class UserControler {
    private final UserService userService;
    @Autowired
    public UserControler(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        Optional<List<User>> optionalUsers = userService.getAllUsers();
        if (optionalUsers.isPresent()) {
            List<User> users = optionalUsers.get();
            if (users.isEmpty()) {
                return Collections.emptyList();
            }
            return users;
        } else {
            return Collections.emptyList();
        }
    }

    @PostMapping("login")
    public String loginUser(@RequestBody @NonNull UserLoginRequest loginRequest){
        if (loginRequest.getEmail() == null || loginRequest.getEmail().isEmpty() ||
                loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            return "Invalid login request"; // Check if email or password is empty
        }
        int loginSatuts=userService.login(loginRequest.getEmail(),loginRequest.getPassword());
        if(loginSatuts==1)
            return "No such User";
        else if(loginSatuts==2)
            return "Wrong Password";
        return "Login Successful!";
    }
    @PostMapping("signup")
    public int signup(@RequestBody User user){
        return userService.signup(user);
    }
    @GetMapping(path="{userId}")
    public int getUserById(@PathVariable("userId")final UUID userId){
        if(userService.getUsersById(userId).isEmpty())
            return 1;//not present
        return 0;//is present
    }

}
