package com.example.majorAssignment.model;

import java.util.UUID;



public class UserResp {

    private String name;
    private UUID userID;



    private String email;

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public UserResp(User user) {
        this.name = user.getName();
        this.userID = user.getId();
        this.email = user.getEmail();
    }

}
