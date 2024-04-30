package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//import java.util.int;

@Repository
public class PostDAO implements PostDA0 {

    private final PostRepo postRepository;
    private final UserDAO userDAO;
    private int postBaseId=1;

    @Autowired
    public PostDAO(PostRepo postRepository, UserDAO userDAO) {
        this.postRepository = postRepository;
        this.userDAO = userDAO;
    }

    @Override
    public int addPost(int postId, Post post,int f) {
        // Check if the post creator exists
        if (!checkCreator(post.getPostCreaterId()))
            return 1; // User doesn't exist
        postId=postBaseId;
        postBaseId++;
        // Save the post to the database
        postRepository.save(post);
        return 0; // Post added successfully
    }
    public int updatePost(int postId,String changedPostContent){
        Optional<Post> currentPost = getPostById(postId);
        if (currentPost.isEmpty())
            return 1; // Post does not exist
        // Update the post content
        currentPost.get().setPostContent(changedPostContent);
        // Save the updated post to the database
        int result = postRepository.updatePostById(postId, changedPostContent);
        return 0;
    }
    public Optional<Post> getPostById(int id){
        return postRepository.findById(id);
    }
    private boolean checkCreator(int creatorId) {
        return userDAO.getUserById(creatorId).isPresent();
    }
    public int deletePostById(int postId) {
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
