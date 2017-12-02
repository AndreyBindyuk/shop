package shop.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.models.Comment;

@Transactional
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
