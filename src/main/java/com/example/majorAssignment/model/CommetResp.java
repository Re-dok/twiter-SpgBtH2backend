package com.example.majorAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//import java.util.int;
class semiUser{
    int uid;
    String name;

    public semiUser(@JsonProperty("userID")int uid,@JsonProperty("name") String name) {
        this.uid = uid;
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class CommetResp {
    int commentID;
    String commentBody;
    semiUser commentCreator;

    public CommetResp(Comments c) {
        this.commentID = c.getCommentId();
        this.commentBody = c.getCommentContent();
        this.commentCreator = new semiUser(c.getCommentCreaterId(),c.getCommentCreaterName());
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public semiUser getcommentCreator() {
        return commentCreator;
    }

    public void setcommentCreator(semiUser commentCreator) {
        this.commentCreator = commentCreator;
    }
}
