package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.response.RewardResponse;
import com.hackathon.swiggy.health.repo.RewardRepo;
import com.hackathon.swiggy.health.vo.Reward;
import javafx.util.Pair;

import java.util.List;

public class RewardController {

    private RewardRepo rewardRepo;

    public RewardResponse get(String userId) {
        Pair<List<Reward>, List<Reward>> pair = rewardRepo.get(userId);
        return new RewardResponse(pair.getKey(), pair.getValue());
    }

}
