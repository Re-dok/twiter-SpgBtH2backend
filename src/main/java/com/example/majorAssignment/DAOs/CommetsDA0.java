package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import org.springframework.lang.NonNull;

//import java.util.int;

public interface CommetsDA0 {

    int addComment(int i,@NonNull Comments comment);

    default public int addComment(Comments comment){
        return addComment(comment.getCommentId(),comment);
    }
}
