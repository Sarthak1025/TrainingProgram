package com.vending.system.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DiscountDao {
    double searchDiscount(String name) throws SQLException, ClassNotFoundException;
}
