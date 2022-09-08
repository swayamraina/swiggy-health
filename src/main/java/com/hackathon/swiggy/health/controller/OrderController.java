package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.request.ItemRequest;
import com.hackathon.swiggy.health.controller.response.OrderResponse;
import com.hackathon.swiggy.health.repo.OrderRepo;
import com.hackathon.swiggy.health.vo.Item;
import com.hackathon.swiggy.health.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/api/user/{user-id}/order/{order-id}")
    public OrderResponse get(
            @PathVariable("user-id") String userId,
            @PathVariable("order-id") String orderId) {

        Order order = orderRepo.get(userId, orderId);
        return new OrderResponse(order);
    }

    @PostMapping(value = "/api/user/{user-id}/next", consumes = "application/json")
    public String saveForNextOrder(
            @PathVariable("user-id") String userId,
            @RequestBody ItemRequest itemRequest) {

        String id = orderRepo.getID();
        Order order = new Order(id);
        order.items.add(itemRequest);
        orderRepo.addToNextOrder(userId, order);
        return id;
    }

}
