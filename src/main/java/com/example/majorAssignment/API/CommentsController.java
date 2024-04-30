package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.CommentsService;
import com.example.majorAssignment.model.Comments;
import com.example.majorAssignment.model.CommetResp;
import com.example.majorAssignment.model.ErrorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//import java.util.int;


@RequestMapping("/comment")
@RestController
public class CommentsController {
    private final CommentsService commentsService;


@Autowired
public CommentsController(CommentsService commentsService) {
            this.commentsService=commentsService;
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comments comment){
        int commAddStatus=commentsService.addCommet(comment);
        if(commAddStatus==1){
            ErrorClass e=new ErrorClass("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
        }
        else if(commAddStatus==2) {
            ErrorClass e=new ErrorClass("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
        }
        return ResponseEntity.ok("Comment created successfully");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCommentById(@RequestParam(name = "CommentID")int commentID){
        int delStatus=commentsService.deleteCommentById(commentID);
            if(delStatus==1){
                ErrorClass e=new ErrorClass("Comment does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
            }
            return ResponseEntity.ok("Comment deleted");
    }

    @PatchMapping
    public ResponseEntity<?> UpdateCommentById(@RequestBody Comments comments){
        int updateStatus=commentsService.updateCommentById(comments.getCommentId(),comments.getCommentContent());
        if(updateStatus==1){
            ErrorClass e=new ErrorClass("Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
        }
        return ResponseEntity.ok("Comment edited successfully");
    }
    @GetMapping(path ="/getAllcomments")
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
    @GetMapping
    public ResponseEntity<?> getCommentById(@RequestParam(name="CommentID")int commentId){
       Optional<Comments>commentStaus=commentsService.getCommentById(commentId);
       if(commentStaus.isEmpty()){
           ErrorClass e=new ErrorClass("Comment does not exist");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
       }
        CommetResp resp=new CommetResp(commentStaus.get());
        return ResponseEntity.ok(resp);
    }
}
