package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDAO implements UserDA0{
    private static List<User> UserDB=new ArrayList<>();
    public int addUser(UUID userId,String email,String name,String password){
        if(getUserByEmail(email).isPresent())
            return 1;//user already present
        UserDB.add(new User(
                userId,
                email,
                name,
                password
        ));
        return 0;//new user added
    }
        public Optional<User> getUserByEmail(String email){
            return UserDB.stream().filter(user -> user.getEmail().equals(email)).findFirst();//find the first match or return null if not found
        }
    public Optional<User> getUserById(UUID userId){
            return UserDB.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }
        public Optional<List<User>> getAllUsers(){
            if(UserDB.isEmpty())
                return Optional.of(null);
            return Optional.of(UserDB);
        }
}
