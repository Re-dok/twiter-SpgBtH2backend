package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
//import java.util.int;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private Date postDate;
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }


    public Post(@JsonProperty("postID")int postId,
               @JsonProperty("userID") int postCreaterId,
               @JsonProperty("postBody") String postContent) {
        this.postId = postId;
        this.postCreaterId = postCreaterId;
        this.postContent = postContent;
        this.postDate=new Date();
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setPostCreaterId(int postCreaterId) {
        this.postCreaterId = postCreaterId;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    public Post(){};
    private int postCreaterId;

    public int getPostId() {
        return postId;
    }

    public int getPostCreaterId() {
        return postCreaterId;
    }

    public String getPostContent() {
        return postContent;
    }
    private String postContent;
}
