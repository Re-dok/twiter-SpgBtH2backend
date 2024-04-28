package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.PostService;
import com.example.majorAssignment.model.Post;
import com.example.majorAssignment.model.PostResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/post")
@RestController
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }
    //TODO add preqOBJ
    @PostMapping
    public String addPost(@RequestBody Post post) {
        int postStatus = postService.addPost(post);
        if(postStatus==1)
            return "User does not exist";
        else
        return "Post created successfully";
    }
    @GetMapping(path = "{postId}")
    public ResponseEntity<?> getPostById(@PathVariable("postId")UUID postId){
        Optional<PostResp>resp= postService.getPostById(postId);
        if(resp.isEmpty())
            return ResponseEntity.ok("Post does not exist");
        return ResponseEntity.ok(resp.get());
    }
    @PatchMapping
    public ResponseEntity<String> updatePost(@RequestBody Post changedPost){
        if(postService.updatePost(changedPost.getPostId(),changedPost.getPostContent())==0)
            return ResponseEntity.ok("Post edited successfully");
        return ResponseEntity.ok("Post does not exist");
    }
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
    @DeleteMapping(path = "{postId}")
    public String deletePost(@PathVariable("postId") UUID postId){
        boolean resp= postService.deletePost(postId);
        if(resp)
            return "Post deleted";
        return "Post does not exist";
    }
}
