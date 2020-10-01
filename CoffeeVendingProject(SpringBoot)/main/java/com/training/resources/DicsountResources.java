package com.training.resources;

import com.training.beans.DiscountCoupon;
import com.training.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DicsountResources {
    @Autowired
    private DiscountService discountService;

    @GetMapping(path = "/discounts", produces = "application/json")
    public ArrayList<DiscountCoupon> getAllDiscounts()
    {
        return discountService.getAllDiscounts();
    }

    @GetMapping(path = "/discounts/{name}", produces = "application/json")
    public double getCouponValue(@PathVariable("name")String name){
        return discountService.getCouponValue(name);
    }

    @GetMapping(path = "/getDiscount/{name}", produces = "application/json")
    public DiscountCoupon getDiscountCoupon(@PathVariable("name")String name){
        return discountService.getDiscount(name);
    }
}
