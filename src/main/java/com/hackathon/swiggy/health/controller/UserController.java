package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    public void create() {

    }

    public void get() {

    }

}
