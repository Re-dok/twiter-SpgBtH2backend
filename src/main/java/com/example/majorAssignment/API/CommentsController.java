package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.CommentsService;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/comment")
@RestController
public class CommentsController {
    private final CommentsService commentsService;
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }
@Autowired
public CommentsController(CommentsService commentsService) {
            this.commentsService=commentsService;
    }
    @PostMapping
    public Comments addComment(@RequestBody Comments comment){
        commentsService.addCommet(comment);
        return comment;
    }
    @GetMapping
    public Optional<List<Comments>> getAllComments(){
        return commentsService.getAllComments();
    }
    @GetMapping(path = "{commentId}")
    public Optional<Comments>getCommentById(@PathVariable("commentId")UUID commentId){
        return commentsService.getCommentById(commentId);
    }
}
