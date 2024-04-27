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
    private String commentContent;

    public UUID getCommentId() {
        return commentId;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getCommentCreaterId() {
        return commentCreaterId;
    }

    public String getCommentContent() {
        return commentContent;
    }


    public Comments(@JsonProperty("commentId")UUID commentId,
                    @JsonProperty("postId") UUID postId,
                    @JsonProperty("commentCreaterId")UUID commentCreaterId,
                    @JsonProperty("commentContent")String commentContent) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentCreaterId = commentCreaterId;
        this.commentContent = commentContent;
    }
}
