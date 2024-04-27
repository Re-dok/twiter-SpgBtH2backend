package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Entity
public class Comments {
    @Id
    private final  UUID commentId;
    private final UUID postId;

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    private final UUID commentCreaterId;
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
