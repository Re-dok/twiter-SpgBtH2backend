package com.example.majorAssignment.DAOs;

import com.example.majorAssignment.model.Comments;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CommentDAO implements CommetsDAO{
private static List<Comments> CommentsDB =new ArrayList<>();
@Override
public int addComment(UUID commentId, Comments comment){
    CommentsDB.add(new Comments(commentId,
                                comment.getPostId(),
                                comment.getCommentCreaterId(),
                                comment.getCommentContent()
            ));
    return 0;
}
public Optional<Comments> getCommentById(UUID commentId){
    return CommentsDB.stream().filter(comment -> comment.getCommentId().equals(commentId)).findFirst();//find the first match or return null if not found
}
public int deleteCommentById(UUID commentId){
    Optional<Comments> comment=getCommentById(commentId);
    if(comment.isEmpty())
        return 1;//nothing to delete
    CommentsDB.remove(comment.get());
        return 0;//successfully deleted
}
public int updateCommentById(UUID commentId,Comments changedComment){
    return getCommentById(commentId).map(c->{
            int commentIndex=CommentsDB.indexOf(c);//find the index of the comment
            if(commentIndex>1){
                    CommentsDB.set(commentIndex,changedComment);//update at that index the changes
                    return 0;//update successfull
            }
            return 1;//no such comment found
    }).orElse(1);
}


}
