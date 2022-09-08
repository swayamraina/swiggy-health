package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.Errors;
import com.hackathon.swiggy.health.vo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserRepo {

    Map<String, User> userIdToUserMapping = new HashMap<>();

    public void create(String userId, User user) {
        User existingUser = userIdToUserMapping.get(userId);
        if (Objects.isNull(existingUser)) {
            userIdToUserMapping.put(userId, user);
        }
        throw new Errors.UserAlreadyExists("user" +  userId + "already exists");
    }

    public User get(String userId) {
        User existingUser = userIdToUserMapping.get(userId);
        if (Objects.isNull(existingUser)) {
            throw new Errors.UserNotFound("user" +  userId + "not found");
        }
        return existingUser;
    }

}
