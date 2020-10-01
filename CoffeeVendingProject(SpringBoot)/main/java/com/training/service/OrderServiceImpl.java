package com.training.service;

import com.training.beans.*;
import com.training.persistence.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private AddOnService addOnService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private DiscountService discountService;

    @Override
    public void getAllOrders() {

        for (Orders2 orders2: orderDao.findAll())
            System.out.println(orders2);
    }

    @Override
    public double generateTrueBill(Order order) {
        double cost = 0;
        int coffeePrice = coffeeService.getCoffeePrice(order.getCoffeeName());
        int addOnPrice = addOnService.getAddOnPrice(order.getAddOnName());
        double sizeRatio = sizeService.getSizeRatio(order.getSizeName());
        cost = cost + coffeePrice;
        cost = cost + addOnPrice;
        cost = cost+ (coffeePrice * sizeRatio);
        return cost;
    }

    @Override
    public double getDiscountPercentage(Order order) {
        return discountService.getCouponValue(order.getCouponCode()) * 100;
    }

    @Override
    public double generateFinalBill(Order order) {
        double trueBill = generateTrueBill(order);
        trueBill = trueBill - (trueBill * discountService.getCouponValue(order.getCouponCode()));

        return trueBill;
    }

    @Override
    public void placeOrder(Order order) {
        Coffee coffee = coffeeService.getCoffee(order.getCoffeeName());
        AddOn addOn = addOnService.getAddOn(order.getAddOnName());
        Size size = sizeService.getSize(order.getSizeName());
        DiscountCoupon discountCoupon = discountService.getDiscount(order.getCouponCode());
        int orderId = orderDao.getMaxOrderId() + 1;
        Orders2 orders2 = new Orders2(orderId, coffee, size, addOn, discountCoupon);
        orderDao.save(orders2);
    }
}
