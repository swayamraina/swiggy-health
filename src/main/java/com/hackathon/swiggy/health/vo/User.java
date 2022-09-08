package com.hackathon.swiggy.health.vo;

import com.hackathon.swiggy.health.controller.request.UserRequest;

public class User {

    public String Id;
    public int score;

    public User() {}

    public User(String Id, UserRequest request) {
        this.Id = Id;
        this.score = request.score;
    }

}
