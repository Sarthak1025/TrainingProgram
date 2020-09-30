package com.vending.system.beans;

public class Size {
    private int sizeId;
    private String sizeName;
    private double ratio;

    public Size() {
    }

    public Size(int sizeId, String sizeName, double ratio) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.ratio = ratio;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Size{" +
                "sizeId=" + sizeId +
                ", sizeName='" + sizeName + '\'' +
                ", ratio=" + ratio +
                '}';
    }
}
