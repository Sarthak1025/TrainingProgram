package serviceLayer;

import persistenceLayer.DiscountDaoImpl;

import java.sql.SQLException;

public class DiscountBLImpl implements DiscountBL{
    @Override
    public double searchCouponValue(String name) throws SQLException, ClassNotFoundException {
        DiscountDaoImpl discountDao = new DiscountDaoImpl();
        double couponValue = discountDao.searchDiscount(name);
        return couponValue;
    }
}
