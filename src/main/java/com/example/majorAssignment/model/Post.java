package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID postId;
    private Date postDate;
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Post() {
        this.postId = UUID.randomUUID(); // Generate a random UUID
        // You may also initialize other fields here if needed
    }
    public Post(@JsonProperty("postID")UUID postId,
               @JsonProperty("userID") UUID postCreaterId,
               @JsonProperty("postBody") String postContent) {
        this.postId = postId;
        this.postCreaterId = postCreaterId;
        this.postContent = postContent;
        this.postDate=new Date();
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public void setPostCreaterId(UUID postCreaterId) {
        this.postCreaterId = postCreaterId;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    private UUID postCreaterId;

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
