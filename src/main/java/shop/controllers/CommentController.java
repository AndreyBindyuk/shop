package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.models.Comment;
import shop.services.CommentService;

import java.util.List;

@RestController
@RequestMapping(value = "/shop/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    private String createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    @RequestMapping(value = "/findAllComments", method = RequestMethod.GET)
    private List<Comment> findAllComments(){
        return commentService.findAllComments();
    }

}
