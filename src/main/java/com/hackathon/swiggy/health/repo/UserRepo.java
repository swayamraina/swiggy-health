package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.Errors;
import com.hackathon.swiggy.health.vo.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class UserRepo {

    private static Integer counter = 0;
    Map<String, User> userIdToUserMapping = new HashMap<>();

    public void create(User user) {
        User existingUser = userIdToUserMapping.get(user.Id);
        if (Objects.isNull(existingUser)) {
            userIdToUserMapping.put(user.Id, user);
        }
    }

    public User get(String userId) {
        User existingUser = userIdToUserMapping.get(userId);
        if (Objects.isNull(existingUser)) {
            throw new Errors.UserNotFound("user " +  userId + " not found");
        }
        return existingUser;
    }

    public String getID() {
        synchronized (counter) {
            counter++;
        }
        return String.valueOf(counter);
    }

}
