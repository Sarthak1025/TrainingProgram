package com.training.service;

import com.training.beans.Order;

public interface OrderService {
    void getAllOrders();
    double generateTrueBill(Order order);
    double getDiscountPercentage(Order order);
    double generateFinalBill(Order order);
    void placeOrder(Order order);
}
