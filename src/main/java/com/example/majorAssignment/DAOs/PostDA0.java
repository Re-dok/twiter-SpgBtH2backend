package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;

import java.util.UUID;

public interface PostDA0 {

    int addPost(UUID postId, Post post);
    default public int addPost(Post post){
        UUID postId=UUID.randomUUID();
       return addPost(postId,post);
    }

}
