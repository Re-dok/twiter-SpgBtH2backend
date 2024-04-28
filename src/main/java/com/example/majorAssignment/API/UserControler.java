package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.UserService;
import com.example.majorAssignment.model.User;
import com.example.majorAssignment.model.UserLoginRequest;
import com.example.majorAssignment.model.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping("/")
public class UserControler {
    private final UserService userService;
    @Autowired
    public UserControler(UserService userService) {
        this.userService = userService;
    }
    //TODO remove password from the responce
    @GetMapping
    public List<UserResp> getAllUsers() {
        Optional<List<User>> optionalUsers = userService.getAllUsers();
        if (optionalUsers.isPresent()) {
            List<User> users = optionalUsers.get();
            if (users.isEmpty()) {
                return Collections.emptyList();
            }
            List<UserResp> userList=new ArrayList<>();
            for (User userDet:users
                 ) {
                userList.add(new UserResp(userDet));
            }
            return userList;
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
            return "User does not exist";
        else if(loginSatuts==2)
            return "Username/Password Incorrect";
        return "Login Successful";
    }
    //TODO make a requestOBJ to be used inplace of User
    @PostMapping("signup")
    public String signup(@RequestBody User user){
        int signupStatus=userService.signup(user);
        if(signupStatus==1)
            return "Forbidden, Account already exists";
        return "Account Creation Successful";
    }

    @GetMapping(path="{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId")final UUID userId){
        Optional<User> u=(userService.getUsersById(userId));
        if(u.isEmpty())
            return ResponseEntity.ok("User does not exist");//not present
        UserResp uRep= new UserResp(u.get());
        return ResponseEntity.ok(uRep);//is present
    }

}
