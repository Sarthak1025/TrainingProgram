package persistenceLayer;

import beans.Order;
import beans.OrderTransaction;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDao {
    void addOrdersRecord(Order order) throws SQLException, ClassNotFoundException;
    void addOrderTransactionRecord(ArrayList<OrderTransaction> orderTransactions) throws SQLException, ClassNotFoundException;
    int getCoffeId(String name) throws SQLException, ClassNotFoundException;
    int getSizeId(String name) throws SQLException, ClassNotFoundException;
    int getAddOnId(String name) throws SQLException, ClassNotFoundException;
    Order getOrderRecord(int orderId) throws SQLException, ClassNotFoundException;
    int getOrderId() throws SQLException, ClassNotFoundException;
    int getCoffeePrice(int coffeeId) throws  SQLException, ClassNotFoundException;
    int getAddOnPrice(int addOnId) throws  SQLException, ClassNotFoundException;
    double getSizeRatio(int sizeId) throws  SQLException, ClassNotFoundException;
    ArrayList<OrderTransaction> getOrderTransactionRecord(int orderId) throws  SQLException, ClassNotFoundException;
}
