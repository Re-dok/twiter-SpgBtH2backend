package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.CommentsService;
import com.example.majorAssignment.model.Comments;
import com.example.majorAssignment.model.CommetResp;
import com.example.majorAssignment.model.ErrorClass;
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
   //TODO add reqObj
    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comments comment){
        int commAddStatus=commentsService.addCommet(comment);
        if(commAddStatus==1){
            ErrorClass e=new ErrorClass("User does not exist");
            return ResponseEntity.ok(e);
        }
        else if(commAddStatus==2) {
            ErrorClass e=new ErrorClass("Post does not exist");
            return ResponseEntity.ok(e);
        }
        return ResponseEntity.ok("Comment created successfully");
    }
    //TODO add reqObj

    @DeleteMapping
    public ResponseEntity<?> deleteCommentById(@RequestBody Comments comment){
        int delStatus=commentsService.deleteCommentById(comment.getCommentId());
            if(delStatus==1){
                ErrorClass e=new ErrorClass("Comment does not exist");
                return ResponseEntity.ok(e);
            }
            return ResponseEntity.ok("Comment deleted");
    }
    //TODO add reqObj

    @PatchMapping
    public ResponseEntity<?> UpdateCommentById(@RequestBody Comments comments){
        int updateStatus=commentsService.updateCommentById(comments.getCommentId(),comments.getCommentContent());
        if(updateStatus==1){
            ErrorClass e=new ErrorClass("Comment does not exist");
            return ResponseEntity.ok(e);
        }
        return ResponseEntity.ok("Comment edited successfully");
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
    //TODO add reqObj
    @GetMapping(path = "{commentId}")
    public ResponseEntity<?> getCommentById(@PathVariable("commentId")UUID commentId){
       Optional<Comments>commentStaus=commentsService.getCommentById(commentId);
       if(commentStaus.isEmpty()){
           ErrorClass e=new ErrorClass("Comment does not exist");
           return ResponseEntity.ok(e);
       }
        CommetResp resp=new CommetResp(commentStaus.get());
        return ResponseEntity.ok(resp);
    }
}
