package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;
@Entity
public class CommunityPost {
    @Id
    private final UUID postId;
    private String postBody;
    private LocalDate dateOfPost;

    public CommunityPost(@JsonProperty("postId")UUID postId,@JsonProperty("postBody") String postBody) {
        this.postId = postId;
        this.postBody = postBody;
        this.dateOfPost = LocalDate.now();
    }

    public UUID getPostId() {
        return postId;
    }

    public String getPostBody() {
        return postBody;
    }

    public LocalDate getDateOfPost() {
        return dateOfPost;
    }
}
