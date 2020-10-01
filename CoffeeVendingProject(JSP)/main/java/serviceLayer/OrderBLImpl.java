package serviceLayer;

import beans.Order;
import beans.OrderTransaction;
import persistenceLayer.OrderDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBLImpl implements OrderBL{
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private DiscountBL discountBL = new DiscountBLImpl();
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void addOrders(String couponCode) throws SQLException, ClassNotFoundException {
        setOrderId(orderDao.getOrderId()+1);

        if (discountBL.searchCouponValue(couponCode) == 0){
            couponCode = "INVALID";
        }
        orderDao.addOrdersRecord(new Order(getOrderId(),couponCode));
    }

    @Override
    public void addOrderTransaction(ArrayList<String> coffeeNames, ArrayList<String> sizeNames, ArrayList<String> addOnNames) throws SQLException, ClassNotFoundException {
        ArrayList<OrderTransaction>orderTransactions = new ArrayList<>();
        for (int i=0; i<coffeeNames.size(); i++){
            String addOn = addOnNames.get(i);
            int addOnId;
            if (addOn.equalsIgnoreCase("n")){
                addOnId =300;
            }
            else {
                addOnId = getAddOnIdBl(addOnNames.get(i));
            }
            orderTransactions.add(new OrderTransaction(orderId,getCoffeIdBl(coffeeNames.get(i)),
                    getSizeIdBl(sizeNames.get(i)),addOnId));
        }
        orderDao.addOrderTransactionRecord(orderTransactions);
    }

    @Override
    public int getCoffeIdBl(String name) throws SQLException, ClassNotFoundException {
        return orderDao.getCoffeId(name);
    }

    @Override
    public int getSizeIdBl(String name) throws SQLException, ClassNotFoundException {
        return orderDao.getSizeId(name);
    }

    @Override
    public int getAddOnIdBl(String name) throws SQLException, ClassNotFoundException {
        return orderDao.getAddOnId(name);
    }

    @Override
    public double generateBill() throws SQLException, ClassNotFoundException {
        System.out.println("Orderid : " +getOrderId());
        Order order = orderDao.getOrderRecord(getOrderId());
        ArrayList<OrderTransaction> orderTransactions = orderDao.getOrderTransactionRecord(getOrderId());
        ArrayList<Double> total = new ArrayList<>();
        for (OrderTransaction orderTransaction: orderTransactions) {
            int addOnPrice = orderDao.getAddOnPrice(orderTransaction.getAddOnId());
            if (orderTransaction.getAddOnId()==300){
                addOnPrice = 0;
            }
            total.add(orderDao.getCoffeePrice(orderTransaction.getCoffeeId())
                    +(orderDao.getCoffeePrice(orderTransaction.getCoffeeId()) * orderDao.getSizeRatio(orderTransaction.getSizeId()))
                    +addOnPrice );
        }
        double sum =0;
        for (int i=0; i<total.size(); i++){
            sum = sum+total.get(i);
        }
        System.out.println("True Amount: Rs."+ sum);
        System.out.println("==================");
        double totalPrice = 0;
        double couponValue;
        couponValue = discountBL.searchCouponValue(order.getCouponCode());
        if (couponValue>0){
            totalPrice = sum - sum * couponValue;
            return totalPrice;
            //System.out.println("Discount Percentage: "+(couponValue*100));
            //System.out.println("Amount to be paid: Rs." + totalPrice);
        }
        else {
            totalPrice = sum;
        }
        return totalPrice;
    }
}
