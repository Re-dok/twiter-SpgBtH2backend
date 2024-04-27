package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.CommentsService;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//TODO add delete comment

@RequestMapping("/comment")
@RestController
public class CommentsController {
    private final CommentsService commentsService;
//TODO remove the hello call here
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }
@Autowired
public CommentsController(CommentsService commentsService) {
            this.commentsService=commentsService;
    }
   //TODO add the conditions for no bad creds
    @PostMapping
    public Comments addComment(@RequestBody Comments comment){
        commentsService.addCommet(comment);
        return comment;
    }
    //TODO should the input type be int only???
    @DeleteMapping
    public String deleteCommentById(@RequestBody Comments comment){
        int delStatus=commentsService.deleteCommentById(comment.getCommentId());
            if(delStatus==1)
                    return "Comment does not exist";
            return "Comment deleted";
    }
    //TODO add a patch req for changing a comment
    @PatchMapping
    public String UpdateCommentById(@RequestBody Comments comments){
        int updateStatus=commentsService.updateCommentById(comments.getCommentId(),comments.getCommentContent());
        if(updateStatus==1)
                return "Comment does not exist";
        return "Comment edited successfully";
    }
    @GetMapping
    public Optional<List<Comments>> getAllComments() {
        Optional<List<Comments>> optionalComments = commentsService.getAllComments();
        if (optionalComments.isPresent()) {
            List<Comments> comments = optionalComments.get();
            if (comments.isEmpty()) {
                return Optional.of(Collections.emptyList());
            }
            return Optional.of(comments);
        } else {
            return Optional.of(Collections.emptyList());
        }
    }
    @GetMapping(path = "{commentId}")
    public Optional<Comments>getCommentById(@PathVariable("commentId")UUID commentId){
        return commentsService.getCommentById(commentId);
    }
}
