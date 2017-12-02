package shop.services;

import shop.models.User;

public interface UserService {

    User createUser(User user);

    User findUser(String email, String password);
}
