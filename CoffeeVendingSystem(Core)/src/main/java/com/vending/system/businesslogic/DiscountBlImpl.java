package com.vending.system.businesslogic;

import com.vending.system.persistence.DiscountDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountBlImpl implements DiscountBL{
    @Override
    public double searchCouponValue(String name) throws SQLException, ClassNotFoundException {
        DiscountDaoImpl discountDao = new DiscountDaoImpl();
        double couponValue = discountDao.searchDiscount(name);
        return couponValue;
    }
}
