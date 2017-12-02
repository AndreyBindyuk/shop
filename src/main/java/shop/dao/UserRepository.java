package shop.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.models.User;

@Transactional
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
