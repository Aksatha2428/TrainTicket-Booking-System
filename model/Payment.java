package model;

public class Payment {

    private static int start = 1;

    private int paymentId;
    private double amount;
    private String status;

    public Payment(double amount) {
        this.paymentId = start++;
        this.amount = amount;
        this.status = "PAID";
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void refund() {
        status = "REFUNDED";
    }

    public String toString() {
        return paymentId + "    " +amount + "    " +status;
    }
}