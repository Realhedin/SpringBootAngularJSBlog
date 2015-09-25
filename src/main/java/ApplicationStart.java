import dao.CommentRepository;
import dao.UserRepository;
import model.Comment;
import model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Main class to run application
 *
 * Created by dkorolev on 9/22/15.
 */
@Configuration
@RestController
@ComponentScan (basePackages = {"controller"})  //add controller package to context
@EnableJpaRepositories(basePackages = "dao")    //add spring data files to context
@EntityScan (basePackages = "model")            //add entities to context
@EnableAutoConfiguration
public class ApplicationStart {

    @RequestMapping("/test")
    @ResponseBody
    String home() {
        return "hello, world!";
    }

    //initialize DB
    @Bean
    CommandLineRunner init(UserRepository userRepository, CommentRepository commentRepository) {
        return (evt) -> {
            User user = new User();
            user.setUsername("dkorolev");
            user.setPassword("123");
            userRepository.save(user);
            Comment comment = new Comment();
            comment.setUser(user);
            comment.setText("test comment");
            comment.setDate(new Date());
            commentRepository.save(comment);
            comment = new Comment();
            comment.setUser(user);
            comment.setText("new test comment");
            comment.setDate(new Date());
            commentRepository.save(comment);

        };
    }


    //starting point
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}

