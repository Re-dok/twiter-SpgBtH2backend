package com.example.majorAssignment.model;

import java.util.List;

public class FeedResp {
private List<PostResp> posts;

    public List<PostResp> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResp> posts) {
        this.posts = posts;
    }
    public FeedResp(List<PostResp> posts) {
        this.posts = posts;
    }
}
