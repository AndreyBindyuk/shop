package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import shop.dao.UserRepository;
import shop.models.User;
import shop.services.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.insert(user);
    }

    public User findUser(String email, String password) {
        Criteria criteria = new Criteria();
        criteria.and("email").is(email).and("password").is(password);
        return mongoTemplate.findOne(new Query(criteria), User.class);
    }
}
