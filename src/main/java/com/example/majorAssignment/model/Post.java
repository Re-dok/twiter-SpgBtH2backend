package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Post {
    @Id
    private final UUID postId;

    public Post(@JsonProperty("postId")UUID postId,
               @JsonProperty("postCreaterId") UUID postCreaterId,
               @JsonProperty("postContent") String postContent) {
        this.postId = postId;
        this.postCreaterId = postCreaterId;
        this.postContent = postContent;
    }

    private final UUID postCreaterId;

    public UUID getPostId() {
        return postId;
    }

    public UUID getPostCreaterId() {
        return postCreaterId;
    }

    public String getPostContent() {
        return postContent;
    }
    private String postContent;
}
