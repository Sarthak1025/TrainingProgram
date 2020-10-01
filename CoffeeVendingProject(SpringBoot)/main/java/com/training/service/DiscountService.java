package com.training.service;

import com.training.beans.DiscountCoupon;

import java.util.ArrayList;

public interface DiscountService {
    ArrayList<DiscountCoupon> getAllDiscounts();
    double getCouponValue(String couponCode);
    DiscountCoupon getDiscount(String name);
}
