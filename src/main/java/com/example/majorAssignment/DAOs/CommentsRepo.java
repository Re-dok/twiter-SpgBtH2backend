package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentsRepo extends JpaRepository<Comments, UUID> {
    List<Comments> findByPostId(UUID postId);
}
