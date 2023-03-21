package com.app.test.controller;

import com.app.test.entity.User;
import com.app.test.service.userService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class userController {

    private userService userService;

    public userController(com.app.test.service.userService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempUsername = user.getUsername();
        String tempPassword = user.getPassword();

        User userObj=null;
        if (tempUsername!=null && tempPassword!=null){
            userObj= userService.getUserByUsername(tempUsername);
        }
        if (userObj == null){
            throw new Exception("User does not Exist");
        }

        return userObj;
    }
}
