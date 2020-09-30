package com.vending.system.businesslogic;

import com.vending.system.beans.Coffee;
import com.vending.system.persistence.CoffeeDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeBlImpl implements CoffeeBL {
    private CoffeeDaoImpl coffeeDao = new CoffeeDaoImpl();

    @Override
    public ArrayList<String> getAllCoffeeNames() throws SQLException, ClassNotFoundException {
        ArrayList<Coffee> coffees = coffeeDao.getAllCoffees();
        ArrayList<String> coffeeList = new ArrayList<>();
        for (Coffee coffee: coffees){
            coffeeList.add(coffee.getCoffeeName());
        }
        return  coffeeList;
    }

    @Override
    public int getCoffeePrice(String name) throws SQLException, ClassNotFoundException {
        Coffee coffee = coffeeDao.searchCoffee(name);
        return coffee.getBasePrice();
    }
}
