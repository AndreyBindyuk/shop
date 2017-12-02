package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import shop.dao.CommentRepository;
import shop.models.Comment;
import shop.services.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public void createComment(Comment comment) {
        commentRepository.insert(comment);
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
}
