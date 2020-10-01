package com.training.beans;

public class Order {
    private String coffeeName;
    private String sizeName;
    private String addOnName;
    private String couponCode;

    public Order() {
    }

    public Order(String coffeeName, String sizeName, String addOnName, String couponCode) {
        this.coffeeName = coffeeName;
        this.sizeName = sizeName;
        this.addOnName = addOnName;
        this.couponCode = couponCode;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "coffeeName='" + coffeeName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", addOnName='" + addOnName + '\'' +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }
}
