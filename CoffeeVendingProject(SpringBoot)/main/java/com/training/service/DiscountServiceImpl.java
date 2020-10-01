package com.training.service;

import com.training.beans.Coffee;
import com.training.beans.DiscountCoupon;
import com.training.persistence.DiscountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountDao discountDao;
    @Override
    public ArrayList<DiscountCoupon> getAllDiscounts() {
        return (ArrayList<DiscountCoupon>) discountDao.findAll();
    }

    @Override
    public double getCouponValue(String couponCode) {
        double couponValue = 0;
        for (DiscountCoupon discountCoupon: getAllDiscounts()){
            if (discountCoupon.getCouponCode().equalsIgnoreCase(couponCode)){
                couponValue = discountCoupon.getCouponValue();
                break;
            }
        }
        return couponValue;
    }

    @Override
    public DiscountCoupon getDiscount(String name) {
        return discountDao.getDiscountCouponByCouponCode(name);
    }
}
