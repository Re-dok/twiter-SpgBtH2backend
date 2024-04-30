package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

//import java.util.int;
@Entity
public class Comments {
    @Id
    @NonNull
    private  int commentId;
    private int commentIdBase=1;
    private String commentContent;
    private String commentCreaterName;
    public void setCommentId(int commentId) {this.commentId=commentId;}
    private int postId;
    public Comments() {
        this.commentId = commentIdBase;
        commentIdBase++;// Generate a random int
        // You may also initialize other fields here if needed
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    private  int commentCreaterId;

    public int getCommentId() {
        return commentId;
    }

    public int getPostId() {
        return postId;
    }

    public String getCommentCreaterName() {
        return commentCreaterName;
    }

    public int getCommentCreaterId() {
        return commentCreaterId;
    }

    public void setCommentCreaterName(String commentCreaterName) {
        this.commentCreaterName = commentCreaterName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Comments(@JsonProperty("commentID")int commentId,
                    @JsonProperty("postID") int postId,
                    @JsonProperty("userID")int commentCreaterId,
                    @JsonProperty("commentBody")String commentContent,
                    @JsonProperty("name")String commentCreaterName) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentCreaterId = commentCreaterId;
        this.commentContent = commentContent;
    }
}
