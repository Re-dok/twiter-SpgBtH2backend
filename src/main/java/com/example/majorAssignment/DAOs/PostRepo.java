package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

public interface PostRepo extends JpaRepository<Post, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.postContent = :changedText WHERE p.id = :postId")
    int updatePostById(UUID postId, String changedText);
}
