package com.training.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddOn {
    @Id
    private int addOnId;
    private String addOnName;
    private int price;

    public AddOn() {
    }

    public AddOn(int addOnId, String addOnName, int price) {
        this.addOnId = addOnId;
        this.addOnName = addOnName;
        this.price = price;
    }

    public int getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(int addOnId) {
        this.addOnId = addOnId;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
