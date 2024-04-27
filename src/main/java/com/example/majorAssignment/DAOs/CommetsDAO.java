package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;

import java.util.UUID;

public interface CommetsDAO {
    int addComment(UUID commentId, Comments comment);

    default public int addComment(Comments comment){
        UUID commentId=UUID.randomUUID();
        return addComment(commentId,comment);
    }
}
