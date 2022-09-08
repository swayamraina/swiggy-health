package com.hackathon.swiggy.health.vo;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public String ID;

    public OrderType type;

    public List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

}
