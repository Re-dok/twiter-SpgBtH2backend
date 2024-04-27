package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;

import java.util.UUID;

public interface CommetsDA0 {
    default int addComment(UUID commentId, Comments comment){
        return 1;
    }

    default public int addComment(Comments comment){
        UUID commentId=UUID.randomUUID();
        return addComment(commentId,comment);
    }
}
