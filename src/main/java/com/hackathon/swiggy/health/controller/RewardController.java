package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.response.RewardResponse;
import com.hackathon.swiggy.health.repo.RewardRepo;
import com.hackathon.swiggy.health.vo.Reward;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RewardController {

    @Autowired
    private RewardRepo rewardRepo;

    @GetMapping("/api/rewards/{user-id}")
    public RewardResponse get(
            @PathVariable("user-id") String userId) {

        Pair<List<Reward>, List<Reward>> pair = rewardRepo.get(userId);
        return new RewardResponse(pair.getKey(), pair.getValue());
    }

    @GetMapping("/api/rewards/create")
    public boolean create() throws IOException {
        rewardRepo.init();
        return true;
    }

}
