package com.vending.system.persistence;

import com.vending.system.beans.Coffee;
import com.vending.system.helpers.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountDaoImpl implements DiscountDao{
    @Override
    public double searchDiscount(String name) throws SQLException, ClassNotFoundException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DISCOUNTCOUPON WHERE COUPONCODE = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        double couponValue;
        if (resultSet.next()){
            couponValue = resultSet.getDouble("couponvalue");
        }
        else {
            couponValue = 0;
        }
        connection.close();
        return couponValue;
    }
}
