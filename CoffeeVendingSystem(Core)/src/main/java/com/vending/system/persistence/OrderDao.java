package com.vending.system.persistence;

import java.sql.SQLException;

public interface OrderDao {
    void addOrdersRecord(int orderId, String couponCode, int addOnId) throws SQLException, ClassNotFoundException;
    void addOrderTransactionRecord(int orderId, int coffeeId, int sizeId) throws SQLException, ClassNotFoundException;
    int getCoffeId(String name) throws SQLException, ClassNotFoundException;
    int getSizeId(String name) throws SQLException, ClassNotFoundException;
    int getAddOnId(String name) throws SQLException, ClassNotFoundException;
}
