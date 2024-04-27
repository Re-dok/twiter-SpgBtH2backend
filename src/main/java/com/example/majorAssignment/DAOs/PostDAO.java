package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PostDAO implements PostDA0 {

    private final PostRepo postRepository;
    private final UserDAO userDAO;

    @Autowired
    public PostDAO(PostRepo postRepository, UserDAO userDAO) {
        this.postRepository = postRepository;
        this.userDAO = userDAO;
    }

    @Override
    public int addPost(UUID postId, Post post) {
        // Check if the post creator exists
        if (!checkCreator(post.getPostCreaterId()))
            return 1; // User doesn't exist

        // Save the post to the database
        postRepository.save(post);

        return 0; // Post added successfully
    }

    private boolean checkCreator(UUID creatorId) {
        return userDAO.getUserById(creatorId).isPresent();
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
