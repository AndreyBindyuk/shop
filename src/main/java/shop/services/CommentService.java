package shop.services;

import shop.models.Comment;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment);

    List<Comment> findAllComments();
}
