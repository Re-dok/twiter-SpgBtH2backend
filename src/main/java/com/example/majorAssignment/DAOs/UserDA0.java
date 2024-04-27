package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import com.example.majorAssignment.model.User;

import java.util.UUID;

public interface UserDA0 {
    int addUser(UUID userId,String email,String name,String password);
    default public int addUser(String email,String name,String password){
        UUID userId=UUID.randomUUID();
        return addUser(userId,email,name,password);
    }
}
