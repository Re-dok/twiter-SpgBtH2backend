package com.example.majorAssignment.model;

//import java.util.int;



public class UserResp {

    private String name;
    private int userID;



    private String email;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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
