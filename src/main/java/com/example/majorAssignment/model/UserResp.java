package com.example.majorAssignment.model;

import java.util.UUID;



public class UserResp {

    private String name;
    private UUID userId;



    private String email;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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
        this.userId = user.getId();
        this.email = user.getEmail();
    }

}
