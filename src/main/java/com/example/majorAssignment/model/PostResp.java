package com.example.majorAssignment.model;

import java.util.List;

public class PostResp{
    public Post getPost() {
        return post;
    }

    public List<Comments> getCommentsOnPost() {
        return commentsOnPost;
    }

    Post post;
    List<Comments> commentsOnPost;

    public PostResp(Post post, List<Comments> commentsOnPost) {
        this.post = post;
        this.commentsOnPost = commentsOnPost;
    }
}
