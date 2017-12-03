package shop.services;

import shop.models.Comment;

import java.util.List;

public interface CommentService {

    String createComment(Comment comment);

    List<Comment> findAllComments();
}
