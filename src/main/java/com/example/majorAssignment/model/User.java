package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Entity
public class User {
    @Id
    private final UUID id;
    private String name;
    @Id
    private String email;
    private final String password;

    public String getPassword() {
        return password;
    }

    public User(@JsonProperty("userId")UUID id,
                @JsonProperty("email")String email,
                @JsonProperty("name")String name,
                @JsonProperty("password")String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
