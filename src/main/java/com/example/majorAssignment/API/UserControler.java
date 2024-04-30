package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.PostService;
import com.example.majorAssignment.Services.UserService;
import com.example.majorAssignment.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping("/")
public class UserControler {
    private final UserService userService;
    private final PostService postService;
    @Autowired
    public UserControler(UserService userService,PostService postService) {
        this.userService = userService;this.postService=postService;
    }
    @GetMapping("/users")
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
    @GetMapping
    public FeedResp getFeed(){
        FeedResp feed=new FeedResp(postService.getFeed());
        return feed;
    }
    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody @NonNull UserLoginRequest loginRequest){
        if (loginRequest.getEmail() == null || loginRequest.getEmail().isEmpty() ||
                loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            ErrorClass e=new ErrorClass("Username/Password Incorrect"); // Check if email or password is empty
            return ResponseEntity.ok(e);
        }
        int loginSatuts=userService.login(loginRequest.getEmail(),loginRequest.getPassword());
        if(loginSatuts==1){
            ErrorClass e=new ErrorClass("User does not exist");
            return ResponseEntity.ok(e);
        }
        else if(loginSatuts==2){
            ErrorClass e=new ErrorClass("Username/Password Incorrect");
            return ResponseEntity.ok(e);
        }
        return ResponseEntity.ok("Login Successful");
    }
    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        int signupStatus=userService.signup(user);
        if(signupStatus==1) {
            ErrorClass e=new ErrorClass("Forbidden, Account already exists");
            return ResponseEntity.ok(e);
        }
        return ResponseEntity.ok("Account Creation Successful");
    }

    @GetMapping("user")
    public ResponseEntity<?> getUserById(@RequestParam(name = "userID") final int userId){
        Optional<User> u=(userService.getUsersById(userId));
        if(u.isEmpty())
            return ResponseEntity.ok("User does not exist");//not present
        UserResp uRep= new UserResp(u.get());
        return ResponseEntity.ok(uRep);//is present
    }

}
