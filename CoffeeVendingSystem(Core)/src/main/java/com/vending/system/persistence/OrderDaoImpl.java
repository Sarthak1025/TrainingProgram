package com.vending.system.persistence;

import com.vending.system.helpers.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao{
    @Override
    public void addOrdersRecord(int orderId, String couponCode, int addOnId) throws SQLException, ClassNotFoundException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ORDERS(ORDERID, COUPONCODE, ADDONID) VALUES(?, ?, ?)");
        preparedStatement.setInt(1, orderId);
        preparedStatement.setString(2, couponCode);
        preparedStatement.setInt(3, addOnId);
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public void addOrderTransactionRecord(int orderId, int coffeeId, int sizeId) throws SQLException, ClassNotFoundException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ORDERTRANSACTION(ORDERID, COFFEEID, SIZEID) VALUES(?, ?, ?)");
        preparedStatement.setInt(1, orderId);
        preparedStatement.setInt(2, coffeeId);
        preparedStatement.setInt(3, sizeId);
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public int getCoffeId(String name) throws SQLException, ClassNotFoundException {
        Connection connection =GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COFFEEID FROM COFFEE WHERE COFFEENAME = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int coffeeID = 0;
        if (resultSet.next()){
            coffeeID = resultSet.getInt("coffeeid");
        }
        connection.close();
        return coffeeID;
    }

    @Override
    public int getSizeId(String name) throws SQLException, ClassNotFoundException {
        Connection connection =GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT SIZEID FROM SIZE WHERE SIZENAME = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int sizeID = 0;
        if (resultSet.next()){
            sizeID = resultSet.getInt("sizeid");
        }
        connection.close();
        return sizeID;
    }

    @Override
    public int getAddOnId(String name) throws SQLException, ClassNotFoundException {
        Connection connection =GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ADDONID FROM ADDON WHERE ADDONNAME = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int addOnID = 0;
        if (resultSet.next()){
            addOnID = resultSet.getInt("addonid");
        }
        connection.close();
        return addOnID;
    }
}
