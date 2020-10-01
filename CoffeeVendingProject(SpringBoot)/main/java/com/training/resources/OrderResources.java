package com.training.resources;

import com.training.beans.Order;
import com.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderResources {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/orderDiscount", produces = "application/json")
    public double getDiscountPercent(Order order){
        return orderService.getDiscountPercentage(order);
    }

    @PostMapping(path = "/order/trueBill", produces = "application/json")
    public double generateTrueBill(Order order) {
        return orderService.generateTrueBill(order);
    }

    @PostMapping(path = "/order/finalBill", produces = "application/json")
    public double generateFinalBill(Order order) {
        return orderService.generateFinalBill(order);
    }

    @PostMapping(path = "/order/placeOrder", produces = "application/json")
    public void placeOrder(Order order){
        orderService.placeOrder(order);
    }

}
