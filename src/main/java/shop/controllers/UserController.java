package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.models.User;
import shop.services.UserService;

@RestController
@RequestMapping(value = "/shop/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    private User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    private User findUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.findUser(email, password);
    }
}
