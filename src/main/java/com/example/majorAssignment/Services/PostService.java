package com.example.majorAssignment.Services;

import com.example.majorAssignment.DAOs.CommentDAO;
import com.example.majorAssignment.DAOs.PostDAO;
import com.example.majorAssignment.model.Comments;
import com.example.majorAssignment.model.Post;
import com.example.majorAssignment.model.PostResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    private final PostDAO postDAO;
    private final CommentDAO commentDAO;

    @Autowired
    public PostService(PostDAO postDAO, CommentDAO commentDAO) {
        this.postDAO = postDAO;
        this.commentDAO = commentDAO;
    }

    public int addPost(Post post) {
        return postDAO.addPost(post);
    }

    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    public boolean deletePost(UUID postId) {
        // Delete comments associated with the post first
        commentDAO.deleteCommentByPostId(postId);
        // Then delete the post
        return postDAO.deletePostById(postId) == 0;
    }
    public int updatePost(UUID id,String changedPostContent){
        return postDAO.updatePost(id,changedPostContent);
    }
    public List<PostResp> getFeed(){
        List<Post> posts = getAllPosts();
        List<PostResp> feed=new ArrayList<>();
        for (Post p:posts
             ) {
            List<Comments> c=commentDAO.getCommentsByPostId(p.getPostId());
            feed.add(new PostResp(p,c));
        }
        feed.sort(Comparator.comparing(postResp -> postResp.getDate(), Comparator.reverseOrder()));
        return feed;
    }
    public Optional<PostResp> getPostById(UUID postId){
        Optional<Post> p=postDAO.getPostById(postId);
        if(p.isEmpty())
            return Optional.empty();
        List<Comments> c=commentDAO.getCommentsByPostId(postId);
        PostResp resp= new PostResp(p.get(),c);
        return Optional.of(resp);
    }
}
