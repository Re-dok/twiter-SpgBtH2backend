package com.example.majorAssignment.Services;

import com.example.majorAssignment.DAOs.PostDA0;
import com.example.majorAssignment.DAOs.PostDAO;
import com.example.majorAssignment.model.Comments;
import com.example.majorAssignment.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostDAO postDAO;
    @Autowired
    public PostService(PostDAO postDAO){
            this.postDAO=postDAO;
    }
    public int addPost(Post post){
        return postDAO.addPost(post);
    }
    public List<Post> getAllPosts(){
        return postDAO.getAllPosts();
    }
}
