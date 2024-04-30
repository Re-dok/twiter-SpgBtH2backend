package com.example.majorAssignment.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
class CommentCreaterDis{
    private UUID userID;
    private String name;

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public CommentCreaterDis(String name,UUID id){
        this.name=name;
        this.userID=id;
    }
}
class commentsDisp{
    private UUID commentID;

    private String commentBody;
    private CommentCreaterDis commentCreator;
    public void setCommentId(UUID commentId) {this.commentID=commentId;}

    public commentsDisp(Comments comments) {
        this.commentID = comments.getCommentId();
        this.commentBody=comments.getCommentContent();
        this.commentCreator=new CommentCreaterDis(comments.getCommentCreaterName(),comments.getCommentCreaterId());
        }
    public void setCommentContent(String commentContent) {
        this.commentBody = commentContent;
    }

    public void setCommentID(UUID commentID) {
        this.commentID = commentID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setCommentCreater(CommentCreaterDis commentCreater) {
        this.commentCreator = commentCreater;
    }

    public UUID getCommentID() {
        return commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public CommentCreaterDis getCommentCreater() {
        return commentCreator;
    }

    public UUID getCommentId() {
        return commentID;
    }

    public String getCommentContent() {
        return commentBody;
    }

}
public class PostResp{

    private UUID postID;
    private String postBody;
    private Date date;
    List<commentsDisp> comments=new ArrayList<>();
    public List<commentsDisp> getCommentsOnPost() {
        return comments;
    }

    public UUID getPostID() {
        return postID;
    }

    public void setPostID(UUID postID) {
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<commentsDisp> getComments() {
        return comments;
    }

    public void setComments(List<commentsDisp> comments) {
        this.comments = comments;
    }

    public PostResp(Post post, List<Comments> commentsOnPost) {
        this.postID = post.getPostId();
        this.postBody= post.getPostContent();
        this.date = post.getPostDate();
        for(Comments c:commentsOnPost){
                this.comments.add(new commentsDisp(c));
        }
    }
}
