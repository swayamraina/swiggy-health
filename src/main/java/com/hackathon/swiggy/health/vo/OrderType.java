package com.hackathon.swiggy.health.vo;

public enum OrderType {

    FOOD(1),
    IM(2),
    GUILT_FREE(3);

    public int ID;

    OrderType(int i) {
        this.ID = i;
    }
}
