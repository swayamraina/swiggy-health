package com.hackathon.swiggy.health.vo;

public enum OrderType {

    FOOD("food"),
    IM("instamart"),
    GUILT_FREE("guiltfree");

    public String type;

    OrderType(String i) {
        this.type = type;
    }

    public static OrderType from (String in) {
        switch (in) {
            case "food": return OrderType.FOOD;
            case "instamart": return OrderType.IM;
            case "guiltfree": return OrderType.GUILT_FREE;
        }
        return OrderType.FOOD;
    }
}
