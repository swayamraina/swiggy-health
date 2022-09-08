package com.hackathon.swiggy.health.vo;

public enum TimeRange {

    TODAY(1),
    WEEK(2),
    MONTH(3);

    public int ID;

    TimeRange(int i) {
        this.ID = i;
    }

    public static TimeRange get(int i) {
        switch (i) {
            case 1: return TimeRange.TODAY;
            case 2: return TimeRange.WEEK;
            case 3: return TimeRange.MONTH;
        }
        return TimeRange.TODAY;
    }

}
