package com.vending.system.presentation;

import java.sql.SQLException;

public interface UserInterface {
    void displayIntroduction() throws SQLException, ClassNotFoundException;
    void displayCoffeeName() throws SQLException, ClassNotFoundException;
    void displaySizeName() throws SQLException, ClassNotFoundException;
    void displayAddOnName() throws SQLException, ClassNotFoundException;
    void addCoffeeWithSize() throws SQLException, ClassNotFoundException;
    void getDiscountCoupon();
    void displayBill() throws SQLException, ClassNotFoundException;
    void placeOrder() throws SQLException, ClassNotFoundException;
}
