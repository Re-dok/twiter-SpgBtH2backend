package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import com.example.majorAssignment.model.Post;
import com.example.majorAssignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public class PostDAO implements PostDA0 {
    private static List<Post> PostsDB =new ArrayList<>();
    private final UserDAO userDAO; // Inject UserDAO dependency

    // Constructor to inject UserDAO dependency
    @Autowired
    public PostDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public int addPost(UUID postId, Post post){
        if(checkCreater(post.getPostCreaterId())==false)
                return 1;//if user doesnt exist
        PostsDB.add(new Post(
                postId,
                post.getPostCreaterId(),
                post.getPostContent()
        ));//if user exists add post
        return 0;
    }
    public boolean checkCreater(UUID createrId){
        Optional<User> user = userDAO.getUserById(createrId);
        return user.isPresent();
    }
    public List<Post> getAllPosts(){
        return PostsDB;
    }
}
