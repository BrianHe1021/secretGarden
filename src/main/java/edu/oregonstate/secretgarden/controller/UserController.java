package edu.oregonstate.secretgarden.controller;

import edu.oregonstate.secretgarden.model.User;
import edu.oregonstate.secretgarden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login/getId")
    public int logInGetId(String email, String password) {

        try {
            User user = userService.getUserByEmail(email);
            // hash password
            password = String.valueOf(password.hashCode());
            return password.equals(user.getPassword()) ? user.getUserId() : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping("/register")
    public boolean register(String userName, String password, String email) {

        try {
            User user = new User();
            user.setUserName(userName);
            // hash password
            user.setPassword(String.valueOf(password.hashCode()));
            user.setEmail(email);


            return userService.insert(user) == 1;
        } catch (Exception e) {
            return false;
        }

    }

    @RequestMapping("/getUserById")
    public User getUserById(int userId) {
        return userService.selectByPrimaryKey(userId);
    }

    @RequestMapping("/getUserByEmail")
    public User getUserByPhone(String email) {
        return userService.getUserByEmail(email);
    }

}
