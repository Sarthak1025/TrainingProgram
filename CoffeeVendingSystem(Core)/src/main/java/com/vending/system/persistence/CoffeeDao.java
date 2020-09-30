package com.vending.system.persistence;

import com.vending.system.beans.Coffee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoffeeDao {
    public ArrayList<Coffee>getAllCoffees() throws SQLException, ClassNotFoundException;
    public Coffee searchCoffee(String name) throws SQLException, ClassNotFoundException;
}
