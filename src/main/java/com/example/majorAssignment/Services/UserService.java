package com.example.majorAssignment.Services;

import com.example.majorAssignment.DAOs.UserDAO;
import com.example.majorAssignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDAO userDAO;
    public Optional<List<User>> getAllUsers(){
        return userDAO.getAllUsers();
    }
    public Optional<User> getUsersById(UUID userId){
        if(userDAO.getUserById(userId).isEmpty())
            return Optional.empty();//if user Not present
        return userDAO.getUserById(userId);
    }
    @Autowired
    public UserService(UserDAO userDAO){
        this.userDAO=userDAO;
    }
    public int signup(User user){
        return userDAO.addUser(user.getEmail(),user.getName(),user.getPassword());
    }
    public int login(String email,String password){
        Optional<User> tempUser=userDAO.getUserByEmail(email);
        if(tempUser.isEmpty())
            return 1;//no such user
        if(Objects.equals(tempUser.get().getPassword(), password))
            return 0;//login success
        return 2;//wrong creds
    }

}
