package com.example.majorAssignment.Services;

import com.example.majorAssignment.DAOs.CommentDAO;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private final CommentDAO commentDAO;

    @Autowired
    public CommentsService(CommentDAO commentDAO){
        this.commentDAO=commentDAO;
    }
    public int addCommet(Comments comment){
        return commentDAO.addComment(comment);
    }

}
