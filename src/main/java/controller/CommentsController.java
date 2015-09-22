package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Additional controller
 *
 * Created by dkorolev on 9/22/15.
 */
@RestController
@RequestMapping("{username}/comments")
public class CommentsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getComments(@PathVariable String username) {
        return "Hello, "+username;
    }
}
