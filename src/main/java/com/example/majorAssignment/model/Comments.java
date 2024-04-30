package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.util.UUID;
@Entity
public class Comments {
    @Id
    @NonNull
    private  UUID commentId;

    private String commentContent;
    private String commentCreaterName;
    public void setCommentId(UUID commentId) {this.commentId=commentId;}
    private UUID postId;
    public Comments() {
        this.commentId = UUID.randomUUID(); // Generate a random UUID
        // You may also initialize other fields here if needed
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    private  UUID commentCreaterId;

    public UUID getCommentId() {
        return commentId;
    }

    public UUID getPostId() {
        return postId;
    }

    public String getCommentCreaterName() {
        return commentCreaterName;
    }

    public UUID getCommentCreaterId() {
        return commentCreaterId;
    }

    public void setCommentCreaterName(String commentCreaterName) {
        this.commentCreaterName = commentCreaterName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Comments(@JsonProperty("commentID")UUID commentId,
                    @JsonProperty("postID") UUID postId,
                    @JsonProperty("userID")UUID commentCreaterId,
                    @JsonProperty("commentBody")String commentContent,
                    @JsonProperty("name")String commentCreaterName) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentCreaterId = commentCreaterId;
        this.commentContent = commentContent;
    }
}
