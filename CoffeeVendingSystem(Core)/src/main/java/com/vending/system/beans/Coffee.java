package com.vending.system.beans;

public class Coffee {
    private int coffeeId;
    private String coffeeName;
    private int basePrice;

    public Coffee() {
    }

    public Coffee(int coffeeId, String coffeeName, int basePrice) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.basePrice = basePrice;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId=" + coffeeId +
                ", coffeeName='" + coffeeName + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
