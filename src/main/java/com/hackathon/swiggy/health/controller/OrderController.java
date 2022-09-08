package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.request.ItemRequest;
import com.hackathon.swiggy.health.controller.response.OrderResponse;
import com.hackathon.swiggy.health.repo.OrderRepo;
import com.hackathon.swiggy.health.vo.Item;
import com.hackathon.swiggy.health.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    public void create() {

    }

    public OrderResponse get(String userId, String orderId) {
        Order order = orderRepo.get(orderId);
        return new OrderResponse(order);
    }

    public void saveForNextOrder(String userId, ItemRequest itemRequest) {
        Order order = new Order();
        order.items.add(new Item(itemRequest));
        orderRepo.addToNextOrder(userId, order);
    }

}
