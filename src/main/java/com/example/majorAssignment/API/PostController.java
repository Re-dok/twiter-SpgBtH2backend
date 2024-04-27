package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.PostService;
import com.example.majorAssignment.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }
    @PostMapping
    public String addPost(@RequestBody Post post) {
        int postStatus = postService.addPost(post);
        if(postStatus==1)
            return "User does not exist";
        else
        return "Post created successfully";
    }
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
}
