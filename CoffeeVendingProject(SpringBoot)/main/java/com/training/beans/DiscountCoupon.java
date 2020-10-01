package com.training.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscountCoupon {
    @Id
    private String couponCode;
    private double couponValue;

    public DiscountCoupon() {
    }

    public DiscountCoupon(String couponCode, double couponValue) {
        this.couponCode = couponCode;
        this.couponValue = couponValue;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(double couponValue) {
        this.couponValue = couponValue;
    }

    @Override
    public String toString() {
        return "DiscountCoupon{" +
                "couponCode='" + couponCode + '\'' +
                ", couponValue=" + couponValue +
                '}';
    }
}
