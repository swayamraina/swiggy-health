package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.request.UserRequest;
import com.hackathon.swiggy.health.controller.response.UserResponse;
import com.hackathon.swiggy.health.repo.UserRepo;
import com.hackathon.swiggy.health.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping(value = "/api/user/create", consumes = "application/json")
    public String create(@RequestBody UserRequest request) {
        String id = userRepo.getID();
        User user = new User(id, request);
        userRepo.create(user);
        return id;
    }

    @GetMapping("/api/user/{user-id}")
    public UserResponse get(@PathVariable("user-id") String userId) {
        User user = userRepo.get(userId);
        return new UserResponse(user);
    }

}
