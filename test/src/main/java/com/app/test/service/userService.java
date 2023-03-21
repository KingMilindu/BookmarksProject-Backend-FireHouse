package com.app.test.service;

import com.app.test.entity.User;
import com.app.test.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userRepository userRepo;
    public userService(userRepository userRepo) {
        this.userRepo = userRepo;
    }


public User getUserByUsername(String userName)
    {
    return userRepo.findByUsername(userName);
    }


}