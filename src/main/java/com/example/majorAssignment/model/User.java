package com.example.majorAssignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.Email;
//import java.util.int;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    private int id;

//    @NotBlank(message = "Name is required")
    private String name;


    @Email(message = "Invalid email address")
    private String email;

//    @NotBlank(message = "Password is required")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public User(int userid){
        this.id=userid;
    };
//    public User(@JsonProperty("email")String email,
//                @JsonProperty("name") String name,
//                @JsonProperty("password") String password){
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
public User() {
    // Default constructor
}
    public User(int id,String email, String name, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
