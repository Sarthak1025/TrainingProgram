package com.vending.system.businesslogic;

import java.sql.SQLException;

public interface DiscountBL {
    double searchCouponValue(String name) throws SQLException, ClassNotFoundException;
}
