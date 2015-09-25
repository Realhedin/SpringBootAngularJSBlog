package dao;

import model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Spring Data Jpa DAO object for Comment object.
 *
 * Created by dkorolev on 9/23/15.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //find all Comments by User's username
    Collection<Comment> findByUserUsername(String username);

    //find all Comments by User's username and which contains text
    Collection<Comment> findByUserUsernameAndTextContaining(String username, String text);
}
