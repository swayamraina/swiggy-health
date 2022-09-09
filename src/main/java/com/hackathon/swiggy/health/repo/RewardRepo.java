package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.services.MockService;
import com.hackathon.swiggy.health.vo.Reward;
import com.hackathon.swiggy.health.vo.Rewards;
import com.hackathon.swiggy.health.vo.User;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class RewardRepo {

    private static Reward lockedReward = new Reward("XXX");

    private List<Reward> rewardMapping = new ArrayList<>();

    @Autowired
    private MockService mockService;

    @Autowired
    private UserRepo userRepo;

    public Pair<List<Reward>, List<Reward>> get(String userId) {
        User user = userRepo.get(userId);
        List<Reward> unlocked = getRewards(user.score);
        List<Reward> locked = Arrays.asList(lockedReward,lockedReward,lockedReward,lockedReward);
        return new Pair<>(locked,  unlocked);
    }

    public void init() throws IOException {
        Rewards rewards = mockService.getRewards();
        rewardMapping.addAll(rewards.rewards);
    }

    private List<Reward> getRewards(int score) {
        List<Reward> response = new ArrayList<>();
        for(int i=0; i<rewardMapping.size(); i++) {
            if (rewardMapping.get(i).score < score) {
                response.add(rewardMapping.get(i));
            }
        }
        return response;
    }

}
