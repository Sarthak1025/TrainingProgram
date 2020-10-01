package beans;

public class OrderTransaction {
    private int orderId;
    private int coffeeId;
    private int sizeId;
    private int addOnId;

    public OrderTransaction() {
    }

    public OrderTransaction(int orderId, int coffeeId, int sizeId, int addOnId) {
        this.orderId = orderId;
        this.coffeeId = coffeeId;
        this.sizeId = sizeId;
        this.addOnId = addOnId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(int addOnId) {
        this.addOnId = addOnId;
    }

    @Override
    public String toString() {
        return "OrderTransaction{" +
                "orderId=" + orderId +
                ", coffeeId=" + coffeeId +
                ", sizeId=" + sizeId +
                ", addOnId=" + addOnId +
                '}';
    }
}
