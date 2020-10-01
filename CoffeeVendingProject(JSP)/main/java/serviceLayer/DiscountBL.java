package serviceLayer;

import java.sql.SQLException;

public interface DiscountBL {
    double searchCouponValue(String name) throws SQLException, ClassNotFoundException;
}
