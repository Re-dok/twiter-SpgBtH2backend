package com.example.majorAssignment.model;

import java.util.UUID;



public class UserResp {




    private String name;
    private UUID id;



    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        this.id = user.getId();
        this.email = user.getEmail();
    }

}
