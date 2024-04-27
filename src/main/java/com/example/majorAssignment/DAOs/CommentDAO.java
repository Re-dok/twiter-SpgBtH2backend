package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CommentDAO implements CommetsDA0 {
    private final CommentsRepo commentsRepository;
    private final UserDAO userDAO;
private final PostDAO postDAO;
    @Autowired
    public CommentDAO(CommentsRepo commentsRepository,UserDAO userDAO,PostDAO postDAO) {
        this.commentsRepository = commentsRepository;
        this.userDAO = userDAO;
        this.postDAO=postDAO;
    }
    private boolean checkCreator(UUID creatorId) {
        return userDAO.getUserById(creatorId).isPresent();
    }

    private boolean checkPost(UUID postId) {
        return postDAO.getPostById(postId).isPresent();
    }
    // Add a new comment
    @Override
    public int addComment(@NonNull Comments comment) {
        comment.setCommentId(UUID.randomUUID());
        if(!checkCreator(comment.getCommentCreaterId()))//check if comment createrId is correct
            return 1;
        else if(!checkPost(comment.getPostId()))
            return 2;//check if post exits
        comment.setCommentId(comment.getCommentId()); // Set the commentId
        commentsRepository.save(comment); // Save the comment to the repository
        return 0;
    }

    // Get a comment by its ID
    public Optional<Comments> getCommentById(UUID commentId) {
        return commentsRepository.findById(commentId);
    }

    // Get all comments
    public Optional<List<Comments>> getAllComments() {
        List<Comments> commentsList = commentsRepository.findAll();
        if (commentsList.isEmpty())
            return Optional.of(Collections.emptyList());
        return Optional.of(commentsList);
    }

    // Delete a comment by its ID
    public int deleteCommentById(UUID commentId) {
        if (commentsRepository.existsById(commentId)) {
            commentsRepository.deleteById(commentId);
            return 0; // Successfully deleted
        } else {
            return 1; // Comment not found
        }
    }

    // Update a comment by its ID
    public int updateCommentById(UUID commentId, Comments changedComment) {
        if (commentsRepository.existsById(commentId)) {
            changedComment.setCommentId(commentId); // Ensure the ID is set
            commentsRepository.save(changedComment); // Save the updated comment
            return 0; // Successfully updated
        } else {
            return 1; // Comment not found
        }
    }
}
