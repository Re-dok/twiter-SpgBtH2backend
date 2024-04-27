package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.CommentsService;
import com.example.majorAssignment.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void addComment(@RequestBody Comments comment){
        commentsService.addCommet(comment);
    }
}
