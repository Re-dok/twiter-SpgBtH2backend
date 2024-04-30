package com.example.majorAssignment.DAOs;

public interface UserDA0 {
    int baseUserId=1;

    int addUser(int userId,String email,String name,String password);
    default public int addUser(String email,String name,String password){
        return addUser(1,email,name,password);
    }
}
