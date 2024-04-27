package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CommentDAO implements CommetsDA0 {
    private final CommentsRepo commentsRepository;

    @Autowired
    public CommentDAO(CommentsRepo commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    // Add a new comment
    public int addComment(UUID commentId, Comments comment) {
        comment.setCommentId(commentId); // Set the commentId
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
