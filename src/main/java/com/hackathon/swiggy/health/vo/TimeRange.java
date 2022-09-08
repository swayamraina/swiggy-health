package com.hackathon.swiggy.health.vo;

public enum TimeRange {

    TODAY(1),
    WEEK(2),
    MONTH(3);

    public int ID;

    TimeRange(int i) {
        this.ID = i;
    }

}
