package controller;

import dao.CommentRepository;
import dao.UserRepository;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Additional controller to operate with comments.
 *
 * Created by dkorolev on 9/22/15.
 */
@RestController
@RequestMapping("{username}/comments")
public class CommentsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Comment> getComments(@PathVariable String username) {
        return commentRepository.findByUserUsername(username);
    }
//    public String getComments(@PathVariable String username) {
//        return "Hello, "+username;
//    }
}
