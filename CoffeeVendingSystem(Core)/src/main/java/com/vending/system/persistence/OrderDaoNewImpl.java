package com.vending.system.persistence;

import com.vending.system.beans.Order;
import com.vending.system.beans.OrderTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.vending.system.helpers.GetConnection.getConnection;

public class OrderDaoNewImpl implements OrderDaoNew{
    @Override
    public void addOrdersRecord(Order order) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ORDERS(ORDERID, COUPONCODE) VALUES(?, ?)");
        int orderId = order.getOrderId();
        String couponCode = order.getCouponCode();
        preparedStatement.setInt(1, orderId);
        preparedStatement.setString(2, couponCode);
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public void addOrderTransactionRecord(ArrayList<OrderTransaction> orderTransactions) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ORDERTRANSACTION(ORDERID, COFFEEID, SIZEID, ADDONID) VALUES(?, ?, ?, ?)");
        for (OrderTransaction orderTransaction: orderTransactions){
            int orderId, coffeeId, sizeId, addOnId;
            orderId = orderTransaction.getOrderId();
            coffeeId = orderTransaction.getCoffeeId();
            sizeId = orderTransaction.getSizeId();
            addOnId = orderTransaction.getAddOnId();
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, coffeeId);
            preparedStatement.setInt(3, sizeId);
            preparedStatement.setInt(4, addOnId);
            preparedStatement.executeUpdate();
        }
        connection.close();
    }

    @Override
    public int getCoffeId(String name) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
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
        Connection connection = getConnection();
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
        Connection connection = getConnection();
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

    @Override
    public Order getOrderRecord(int orderId) throws SQLException, ClassNotFoundException {
        Order order = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERS WHERE ORDERID = ?");
        preparedStatement.setInt(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int oId = resultSet.getInt("orderid");
            System.out.println(oId);
            String couponCode = resultSet.getString("couponcode");
            System.out.println(couponCode);
            order = new Order(oId,couponCode);
        }
        connection.close();
        return order;
    }

    @Override
    public int getOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(ORDERID) FROM ORDERS");
        ResultSet resultSet = preparedStatement.executeQuery();
        int orderId;
        if (resultSet.next()){
            orderId = resultSet.getInt(1);
        }
        else
            orderId = 0;

        return orderId;
    }

    @Override
    public int getCoffeePrice(int coffeeId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT PRICE FROM COFFEE WHERE COFFEEID = ?");
        preparedStatement.setInt(1, coffeeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int price = 0;
        if (resultSet.next()){
            price = resultSet.getInt("price");
        }
        connection.close();
        return price;
    }

    @Override
    public int getAddOnPrice(int addOnId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT PRICE FROM ADDON WHERE ADDONID = ?");
        preparedStatement.setInt(1, addOnId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int price = 0;
        if (resultSet.next()){
            price = resultSet.getInt("price");
        }
        connection.close();
        return price;
    }

    @Override
    public double getSizeRatio(int sizeId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT RATIO FROM SIZE WHERE SIZEID = ?");
        preparedStatement.setInt(1, sizeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        double ratio = 0;
        if (resultSet.next()){
            ratio = resultSet.getDouble("ratio");
        }
        connection.close();
        return ratio;
    }

    @Override
    public ArrayList<OrderTransaction> getOrderTransactionRecord(int orderId) throws SQLException, ClassNotFoundException {
        ArrayList<OrderTransaction>orderTransactions = new ArrayList<>();
        OrderTransaction orderTransaction;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERTRANSACTION WHERE ORDERID = ?");
        preparedStatement.setInt(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int oId = resultSet.getInt("orderid");
            int cID = resultSet.getInt("coffeeid");
            int sId = resultSet.getInt("sizeid");
            int aId = resultSet.getInt("addonid");
            orderTransaction = new OrderTransaction(oId,cID,sId,aId);
            orderTransactions.add(orderTransaction);
        }
        connection.close();
        return orderTransactions;
    }
}
