package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.dao.CommentRepository;
import shop.models.Comment;
import shop.services.CommentService;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public String createComment(Comment comment) {
        return commentRepository.insert(comment).getId();
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
}
