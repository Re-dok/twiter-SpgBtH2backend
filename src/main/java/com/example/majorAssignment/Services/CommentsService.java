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
    public int deleteCommentById(UUID commentId){
        return commentDAO.deleteCommentById(commentId);
    }
    public int updateCommentById(UUID commentId,String commentBody){
            Optional<Comments> tempCom=getCommentById(commentId);
            if(tempCom.isEmpty())
                return 1;//no such comment is present
            tempCom.get().setCommentContent(commentBody);
            return commentDAO.updateCommentById(commentId,tempCom.get());//returns the result of the lower layer
    }
    public Optional<Comments> getCommentById(UUID commentId){
        return commentDAO.getCommentById(commentId);
    }

}
