package persistenceLayer;

import java.sql.SQLException;

public interface DiscountDao {
    double searchDiscount(String name) throws SQLException, ClassNotFoundException;
}
