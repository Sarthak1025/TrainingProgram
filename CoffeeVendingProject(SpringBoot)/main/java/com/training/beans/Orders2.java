package com.training.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Orders2 {
    @Id
    private int orderId;
    @OneToOne
    @JoinColumn(name = "coffeeid")
    private Coffee coffee;
    @OneToOne
    @JoinColumn(name = "sizeid")
    private Size size;
    @OneToOne
    @JoinColumn(name = "addonid")
    private AddOn addOn;
    @OneToOne
    @JoinColumn(name = "couponcode")
    private DiscountCoupon discountCoupon;

    public Orders2() {
    }

    public Orders2(int orderId, Coffee coffee, Size size, AddOn addOn, DiscountCoupon discountCoupon) {
        this.orderId = orderId;
        this.coffee = coffee;
        this.size = size;
        this.addOn = addOn;
        this.discountCoupon = discountCoupon;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public AddOn getAddOn() {
        return addOn;
    }

    public void setAddOn(AddOn addOn) {
        this.addOn = addOn;
    }

    public DiscountCoupon getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(DiscountCoupon discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    @Override
    public String toString() {
        return "Orders2{" +
                "orderId=" + orderId +
                ", coffee=" + coffee +
                ", size=" + size +
                ", addOn=" + addOn +
                ", discountCoupon=" + discountCoupon +
                '}';
    }
}
