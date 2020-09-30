package com.vending.system.presentation;

import com.vending.system.businesslogic.*;
import com.vending.system.helpers.GetConnection;
import com.vending.system.persistence.OrderDaoNewImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    private CoffeeBlImpl coffeeBl = new CoffeeBlImpl();
    private ArrayList<String> coffeeNames = new ArrayList<>();

    private SizeBLImpl sizeBL = new SizeBLImpl();
    private ArrayList<String> sizeNames = new ArrayList<>();

    private AddOnBlImpl addOnBl = new AddOnBlImpl();
    private ArrayList<String> addOnNames = new ArrayList<>();

    private String couponCode;
    OrderBlNewImpl orderBlNew = new OrderBlNewImpl();

    @Override
    public void displayIntroduction() {
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println("Welcome to SarthBucks ;)");
        System.out.println("=======================");
        System.out.println("Would you like to have some coffee y/n?");
        answer = sc.next();
        if (answer.equalsIgnoreCase("n")){
            System.out.println("Thank you! For visiting us!!");
            System.exit(0);
        }
    }

    @Override
    public void displayCoffeeName() throws SQLException, ClassNotFoundException {
        ArrayList<String> coffeeNames = coffeeBl.getAllCoffeeNames();
        System.out.println("====================");
        System.out.println("Here's the menu :)");
        System.out.println("-----------------------");
        for (String string: coffeeNames){
            System.out.println(string);
        }
        System.out.println("-----------------------");
    }

    @Override
    public void displaySizeName() throws SQLException, ClassNotFoundException {
        ArrayList<String> sizeNames = sizeBL.getAllSizeNames();
        System.out.println("Select your Coffee Size :)");
        System.out.println("--------------------------");
        for (String string: sizeNames){
            System.out.println(string);
        }
        System.out.println("--------------------------");
    }

    @Override
    public void displayAddOnName() throws SQLException, ClassNotFoundException {
        ArrayList<String> addOnNames = addOnBl.getAllAddOnNames();
        System.out.println("Select your AddOn, enter n if you don't need it :)");
        System.out.println("--------------------------");
        for (int i=1; i<addOnNames.size(); i++){
            System.out.println(addOnNames.get(i));
        }
        System.out.println("--------------------------");
    }

    @Override
    public void addCoffeeWithSize() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String answer;
        do{
            displayCoffeeName();
            System.out.println("Select your Coffee<3");
            String coffee = sc.next();
            coffeeNames.add(coffee);
            displaySizeName();
            String size = sc.next();
            sizeNames.add(size);
            displayAddOnName();
            String addOnName = sc.next();
            addOnNames.add(addOnName);
            System.out.println("Do you want to order more coffee y/n?");
            answer = sc.next();
        }while (answer.equalsIgnoreCase("y"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void getDiscountCoupon() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Coupon Code:");
        couponCode = sc.next();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void placeOrder() throws SQLException, ClassNotFoundException {
        orderBlNew.addOrders(couponCode);
        orderBlNew.addOrderTransaction(coffeeNames,sizeNames,addOnNames);
    }

    @Override
    public void displayBill() throws SQLException, ClassNotFoundException {
        orderBlNew.generateBill();
    }
}
