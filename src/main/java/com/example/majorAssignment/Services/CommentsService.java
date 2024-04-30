package com.example.majorAssignment.Services;

import com.example.majorAssignment.DAOs.CommentDAO;
import com.example.majorAssignment.DAOs.PostDAO;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentsService {
    private final PostDAO postDAO;
    private final CommentDAO commentDAO;
    public Optional<List<Comments>> getAllComments(){
        return commentDAO.getAllComments();
    }

    @Autowired
    public CommentsService(CommentDAO commentDAO,PostDAO postDAO){
        this.commentDAO=commentDAO; this.postDAO=postDAO;
    }
    private boolean checkPost(UUID postId) {
        return postDAO.getPostById(postId).isPresent();
    }
    public int addCommet(Comments comment){
        if(!checkPost(comment.getPostId()))
            return 2;//check if post exits
        return commentDAO.addComment(comment);
    }
    public int deleteCommentById(UUID commentId){
        Optional<Comments> tempCom=getCommentById(commentId);
        if(tempCom.isEmpty())
            return 1;
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
