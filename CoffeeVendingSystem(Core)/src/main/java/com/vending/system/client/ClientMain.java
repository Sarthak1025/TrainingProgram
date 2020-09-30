package com.vending.system.client;

import com.vending.system.presentation.UserInterfaceImpl;

import java.sql.SQLException;

public class ClientMain {
    public static void main(String[] args){
        try{
            UserInterfaceImpl userInterface = new UserInterfaceImpl();
            userInterface.displayIntroduction();
            userInterface.addCoffeeWithSize();
            userInterface.getDiscountCoupon();
            userInterface.placeOrder();
            userInterface.displayBill();

        }
        catch (SQLException | ClassNotFoundException | RuntimeException e){
            System.out.println("Something went wrong!!!");
        } catch (Exception exception){
            System.out.println("Something went wrong!!!\nTry again with different inputs");
        }

   }
}
