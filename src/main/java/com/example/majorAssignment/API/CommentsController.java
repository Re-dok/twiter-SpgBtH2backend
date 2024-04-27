package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.CommentsService;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
    public String addComment(@RequestBody Comments comment){
        int commAddStatus=commentsService.addCommet(comment);
        if(commAddStatus==1)
            return "User id wrong";
        else if(commAddStatus==2)
            return "Post not available";
        return "Commented";
    }
    //TODO should the input type be int only???
    @DeleteMapping
    public String deleteCommentById(@RequestBody Comments comment){
        int delStatus=commentsService.deleteCommentById(comment.getCommentId());
            if(delStatus==1)
                    return "Comment does not exist";
            return "Comment deleted";
    }

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
    public ResponseEntity<?> getCommentById(@PathVariable("commentId")UUID commentId){
       Optional<Comments>commentStaus=commentsService.getCommentById(commentId);
       if(commentStaus.isEmpty())
           return ResponseEntity.ok("Comment does not exist");
        return ResponseEntity.ok(commentStaus.get());
    }
}
