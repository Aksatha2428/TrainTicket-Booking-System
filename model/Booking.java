package model;

import java.util.ArrayList;

public class Booking {

    private static int start = 1001;

    private int bookingId;
    private String userEmail;
    private Train train;
    private TrainClass trainClass;
    private ArrayList<Passenger> passengers;
    private double totalAmount;
    private Payment payment;
    private String status;

    public Booking(String userEmail,Train train,TrainClass trainClass,ArrayList<Passenger> passengers,double totalAmount,Payment payment) {
            this.bookingId = start++;
            this.userEmail = userEmail;
            this.train = train;
            this.trainClass = trainClass;
            this.passengers = passengers;
            this.totalAmount = totalAmount;
            this.payment = payment;
            this.status = "CONFIRMED";
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Train getTrain() {
        return train;
    }

    public TrainClass getTrainClass() {
        return trainClass;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getStatus() {
        return status;
    }

    public void cancel() {
        status = "CANCELLED";
        payment.refund();
    }

    public String toString() {
        return bookingId + "    " +userEmail + "    " +totalAmount + "    " +status;
    }
}