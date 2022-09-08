package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.request.ItemRequest;
import com.hackathon.swiggy.health.controller.request.PlaceOrderRequest;
import com.hackathon.swiggy.health.repo.OrderRepo;
import com.hackathon.swiggy.health.vo.Item;
import com.hackathon.swiggy.health.vo.Order;
import com.hackathon.swiggy.health.vo.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/api/user/{user-id}/order/{order-id}")
    public Order get(
            @PathVariable("user-id") String userId,
            @PathVariable("order-id") String orderId) {

        Order order = orderRepo.get(userId, orderId);
        return order;
    }

    @PostMapping(value = "/api/user/{user-id}/order/next", consumes = "application/json")
    public String saveForNextOrder(
            @PathVariable("user-id") String userId,
            @RequestBody ItemRequest itemRequest) {

        String id = orderRepo.getID();
        Order order = new Order(id);
        order.items.add(itemRequest);
        orderRepo.addToNextOrder(userId, order);
        return id;
    }

    @PostMapping(value = "/api/user/{user-id}/order/{type}", consumes = "application/json")
    public String placeOrder(
            @PathVariable("user-id") String userId,
            @PathVariable("type") String type,
            @RequestBody PlaceOrderRequest request) {

        String id = orderRepo.getID();
        Order order = new Order(id);
        OrderType orderType = OrderType.from(type);
        order.type = orderType;
        order.items.addAll(request.items);
        orderRepo.create(userId, order);
        return id;
    }

}
