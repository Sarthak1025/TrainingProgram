package com.vending.system.businesslogic;

import com.vending.system.beans.Order;
import com.vending.system.beans.OrderTransaction;
import com.vending.system.persistence.OrderDaoNewImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBlNewImpl implements OrderBlNew{
    OrderDaoNewImpl orderDaoNew = new OrderDaoNewImpl();
    DiscountBlImpl discountBl = new DiscountBlImpl();
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void generateBill() throws SQLException, ClassNotFoundException {
        System.out.println("Orderid : " +getOrderId());
        Order order = orderDaoNew.getOrderRecord(getOrderId());
        ArrayList<OrderTransaction> orderTransactions = orderDaoNew.getOrderTransactionRecord(getOrderId());
        ArrayList<Double> total = new ArrayList<>();
        for (OrderTransaction orderTransaction: orderTransactions) {
            int addOnPrice = orderDaoNew.getAddOnPrice(orderTransaction.getAddOnId());
            if (orderTransaction.getAddOnId()==300){
                addOnPrice = 0;
            }
            total.add(orderDaoNew.getCoffeePrice(orderTransaction.getCoffeeId())
                    +(orderDaoNew.getCoffeePrice(orderTransaction.getCoffeeId()) * orderDaoNew.getSizeRatio(orderTransaction.getSizeId()))
                    +addOnPrice );
        }
        double sum =0;
        for (int i=0; i<total.size(); i++){
            sum = sum+total.get(i);
        }
        System.out.println("True Amount: Rs."+ sum);
        System.out.println("==================");
        double totalPrice ;
        double couponValue;
        couponValue = discountBl.searchCouponValue(order.getCouponCode());
        if (couponValue>0){
            totalPrice = sum - sum * couponValue;
            System.out.println("Discount Percentage: "+(couponValue*100));
            System.out.println("Amount to be paid: Rs." + totalPrice);
        }

    }


    @Override
    public void addOrders(String couponCode) throws SQLException, ClassNotFoundException {
        setOrderId(orderDaoNew.getOrderId()+1);

        if (discountBl.searchCouponValue(couponCode) == 0){
            couponCode = "INVALID";
        }
        orderDaoNew.addOrdersRecord(new Order(getOrderId(),couponCode));
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
        orderDaoNew.addOrderTransactionRecord(orderTransactions);
    }

    @Override
    public int getCoffeIdBl(String name) throws SQLException, ClassNotFoundException {
        return orderDaoNew.getCoffeId(name);
    }

    @Override
    public int getSizeIdBl(String name) throws SQLException, ClassNotFoundException {
        return orderDaoNew.getSizeId(name);
    }

    @Override
    public int getAddOnIdBl(String name) throws SQLException, ClassNotFoundException {
        return orderDaoNew.getAddOnId(name);
    }


}
