package com.hackathon.swiggy.health.vo;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public String Id;
    public OrderType type;
    public List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(String id) {
        this.Id = id;
        this.items = new ArrayList<>();
    }

}
