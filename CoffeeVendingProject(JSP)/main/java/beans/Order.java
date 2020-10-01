package beans;

public class Order {
    private int orderId;
    private String couponCode;

    public Order() {
    }

    public Order(int orderId, String couponCode) {
        this.orderId = orderId;
        this.couponCode = couponCode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }
}
