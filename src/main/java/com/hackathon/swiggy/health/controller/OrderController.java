package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.request.ItemRequest;
import com.hackathon.swiggy.health.controller.response.OrderResponse;
import com.hackathon.swiggy.health.repo.OrderRepo;
import com.hackathon.swiggy.health.vo.Item;
import com.hackathon.swiggy.health.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    public void create() {

    }

    @GetMapping("/api/user/{user-id}/order/{order-id}")
    public OrderResponse get(
            @PathVariable("user-id") String userId,
            @PathVariable("order-id") String orderId) {

        Order order = orderRepo.get(orderId);
        return new OrderResponse(order);
    }

    @GetMapping("/api/user/{user-id}/next")
    public void saveForNextOrder(
            @PathVariable("user-id") String userId,
            @RequestBody ItemRequest itemRequest) {

        Order order = new Order();
        order.items.add(itemRequest);
        orderRepo.addToNextOrder(userId, order);
    }

}
