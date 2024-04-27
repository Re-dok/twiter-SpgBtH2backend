package com.example.majorAssignment.Services;

import com.example.majorAssignment.DAOs.CommentDAO;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentsService {
    private final CommentDAO commentDAO;
    public Optional<List<Comments>> getAllComments(){
        return commentDAO.getAllComments();
    }
    @Autowired
    public CommentsService(CommentDAO commentDAO){
        this.commentDAO=commentDAO;
    }
    public int addCommet(Comments comment){
        return commentDAO.addComment(comment);
    }
    public Optional<Comments> getCommentById(UUID commentId){
        return commentDAO.getCommentById(commentId);
    }

}
