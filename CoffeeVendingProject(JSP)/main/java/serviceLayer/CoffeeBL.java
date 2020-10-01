package serviceLayer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoffeeBL {
    ArrayList<String> getAllCoffeeNames() throws SQLException, ClassNotFoundException;
    int getCoffeePrice(String name) throws SQLException, ClassNotFoundException;
}
