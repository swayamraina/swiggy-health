package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.vo.Reward;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RewardRepo {

    private static List<Reward> emptyList = new ArrayList<>();

    private Map<String, List<Reward>> userIdToLockedRewardMapping = new HashMap<>();
    private Map<String, List<Reward>> userIdToUnlockedRewardMapping = new HashMap<>();

    public Pair<List<Reward>, List<Reward>> get(String userId) {
        List<Reward> locked = getLocked(userId);
        List<Reward> unlocked = getUnlocked(userId);
        return new Pair<>(locked,  unlocked);
    }





    private List<Reward> getLocked(String userId) {
        return getXRewards(userId, userIdToLockedRewardMapping);
    }

    private List<Reward> getUnlocked(String userId) {
        return getXRewards(userId, userIdToUnlockedRewardMapping);
    }

    private List<Reward> getXRewards(String userId, Map<String, List<Reward>> userIdToUnlockedRewardMapping) {
        List<Reward> locked = userIdToUnlockedRewardMapping.get(userId);
        if (Objects.isNull(locked) || 0 == locked.size()) {
            return emptyList;
        }
        return locked;
    }

}
