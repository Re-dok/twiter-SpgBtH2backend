package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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
    public Optional<Post> getPostById(UUID id){
        return postRepository.findById(id);
    }
    private boolean checkCreator(UUID creatorId) {
        return userDAO.getUserById(creatorId).isPresent();
    }
    public int deletePostById(UUID postId) {
        if (postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
            return 0; // Successfully deleted
        } else {
            return 1; // Post not found
        }
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
