package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;

public interface PostDA0 {

    int addPost(int postId, Post post,int f);
    default public int addPost(Post post){
       return addPost(1,post,1);
    }

}
