package controller;

import dao.CommentRepository;
import dao.UserRepository;
import model.Comment;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

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


    //get all comments for user
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Comment> getComments(@PathVariable String username) {
        return commentRepository.findByUserUsername(username);
    }

    //add new comment for user
    @RequestMapping(method = RequestMethod.POST)
    public void createComment(@PathVariable String username, @Valid @RequestBody Comment comment) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        comment.setUser(user);
        commentRepository.save(comment);
    }

    //delete comment for user
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteComment(@RequestParam Long id) {
        commentRepository.delete(id);
//        System.out.println();
    }



    //exception if user was not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String username) {
            super("could not find user '" + username + "'.");
        }
    }
}
