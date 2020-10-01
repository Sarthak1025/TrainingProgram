package serviceLayer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBL {
    void addOrders(String couponCode) throws SQLException, ClassNotFoundException;
    void addOrderTransaction(ArrayList<String> coffeeNames, ArrayList<String>SizeNames, ArrayList<String>addOnNames) throws SQLException, ClassNotFoundException;
    int getCoffeIdBl(String name) throws SQLException, ClassNotFoundException;
    int getSizeIdBl(String name) throws SQLException, ClassNotFoundException;
    int getAddOnIdBl(String name) throws SQLException, ClassNotFoundException;
    double generateBill() throws  SQLException, ClassNotFoundException;
}
