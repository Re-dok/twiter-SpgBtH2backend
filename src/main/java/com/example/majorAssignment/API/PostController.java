package com.example.majorAssignment.API;

import com.example.majorAssignment.Services.PostService;
import com.example.majorAssignment.model.ErrorClass;
import com.example.majorAssignment.model.Post;
import com.example.majorAssignment.model.PostResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
//import java.util.int;

@RequestMapping("/post")
@RestController
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        int postStatus = postService.addPost(post);
        if(postStatus==1){
            ErrorClass e=new ErrorClass("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
        }
        else
        return ResponseEntity.ok("Post created successfully");
    }
    @GetMapping
    public ResponseEntity<?> getPostById(@RequestParam(name="postID")int postId){
        Optional<PostResp>resp= postService.getPostById(postId);
        if(resp.isEmpty()){
            ErrorClass e=new ErrorClass("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
        }
        return ResponseEntity.ok(resp.get());
    }
    @PatchMapping
    public ResponseEntity<?> updatePost(@RequestBody Post changedPost){
        if(postService.updatePost(changedPost.getPostId(),changedPost.getPostContent())==0)
            return ResponseEntity.ok("Post edited successfully");
        ErrorClass e=new ErrorClass("Post does not exist");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
    }
    @GetMapping(path = "getAllPost")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
    @DeleteMapping
    public ResponseEntity<?> deletePost(@RequestParam(name="postID") int postId){
        boolean resp= postService.deletePost(postId);
        if(resp)
            return ResponseEntity.ok("Post deleted");
        ErrorClass e=new ErrorClass("Post does not exist");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error",e.getError()));
    }
}
