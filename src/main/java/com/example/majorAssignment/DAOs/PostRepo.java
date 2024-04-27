package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepo extends JpaRepository<Post, UUID> {
}
