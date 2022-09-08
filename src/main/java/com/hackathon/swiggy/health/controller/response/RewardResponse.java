package com.hackathon.swiggy.health.controller.response;

import com.hackathon.swiggy.health.vo.Reward;

import java.util.List;

public class RewardResponse {

    public List<Reward> locked;
    public List<Reward> getLocked() { return locked; }

    public List<Reward> unlocked;
    public List<Reward> getUnlocked() { return unlocked; }

    public RewardResponse (List<Reward> locked, List<Reward> unlocked) {
        this.locked = locked;
        this.unlocked = unlocked;
    }

}
