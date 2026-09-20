package model;

public class TrainClass {

    private static int start = 1;

    private int classId;
    private String className;
    private int totCapacity;
    private int availSeat;
    private double price;

    public TrainClass(String className, int totCapacity, double price) {
        this.classId = start++;
        this.className = className;
        this.totCapacity = totCapacity;
        this.availSeat = totCapacity;
        this.price = price;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public int getTotCapacity() {
        return totCapacity;
    }

    public int getAvailSeat() {
        return availSeat;
    }

    public double getPrice() {
        return price;
    }

    public void reduceSeats(int count) {
        availSeat -= count;
    }

    public void increaseSeats(int count) {
        availSeat += count;
    }

    public String toString() {
        return classId + "    " +className + "      " +totCapacity + "      " +availSeat + "      " +price;
    }
}