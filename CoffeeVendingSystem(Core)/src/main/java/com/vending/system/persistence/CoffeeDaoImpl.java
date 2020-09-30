package com.vending.system.persistence;

import com.vending.system.helpers.GetConnection;
import com.vending.system.beans.Coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeDaoImpl implements CoffeeDao{

    @Override
    public ArrayList<Coffee> getAllCoffees() throws SQLException, ClassNotFoundException {
        ArrayList<Coffee> coffeeList = new ArrayList<>();
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM COFFEE");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("coffeeid");
            //System.out.println(id);
            String name = resultSet.getString("coffeename");
            int price = resultSet.getInt("price");
            //System.out.println(id+' '+name+' '+price);
            coffeeList.add(new Coffee(id,name,price));
        }
        connection.close();
        return coffeeList;
    }

    @Override
    public Coffee searchCoffee(String name) throws SQLException, ClassNotFoundException {
        Coffee coffee = null;
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM COFFEE WHERE COFFEENAME = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("coffeeid");
            String name1 = resultSet.getString("coffeename");
            int price = resultSet.getInt("price");
            coffee = new Coffee(id, name1, price);
        }
        connection.close();
        return coffee;
    }


}
