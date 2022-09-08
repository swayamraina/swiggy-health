package com.hackathon.swiggy.health.controller.response;

import com.hackathon.swiggy.health.controller.request.UserRequest;
import com.hackathon.swiggy.health.vo.User;

public class UserResponse extends UserRequest {

    public String id;
    public String getId() { return id; }

    public UserResponse(User user) {
        this.id = user.Id;
        this.score = user.score;
    }

}
