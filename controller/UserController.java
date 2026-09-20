package controller;
import repository.UserRepo;
import model.User;
import repository.TrainRepo;
import model.TrainClass;
import model.Train;
import view.TrainView;
import java.util.*;
import model.Booking;
import model.Passenger;
import model.Payment;
import view.TrainView;
import repository.BookingRepo;
import java.util.ArrayList;
public class UserController{
    
    static UserRepo userR = new UserRepo();
    private TrainRepo t;
    private BookingRepo bookingRepo = new BookingRepo();
    public UserController(TrainRepo t){
        this.t = t;
    }
    public static boolean Login(String email, String password){
        User user = userR.getUser(email);
        if(user==null){
            System.out.println();
            System.out.println("User Not Created");
            System.out.println("Register to continue");
            System.out.println();
            return false;
            
        }
        if(user.getPass().equals(password)){
             System.out.println("Login successful");
             return true;
        }
        else{
            System.out.print("Invalid credentials");
            return false;
        }
    }
    
    public static boolean containsUser(String email){
        User user = userR.getUser(email);
        return user!=null;
    }
    
    public static void createUser(String userName, String email, String password, String phno){
        User user = new User(userName,email,password,phno);
        userR.save(user);
    }

    public void showTrain(){
        TrainView.showTrain(t);
    }

    public void showClass(int id){
        Train train = t.getTrain(id);
        ArrayList<TrainClass> c = t.getClass(train);
        System.out.println("Class ID     Class Name      Total Capacity      Available Seats        Price/seat");
        for(int i=0;i<c.size();i++){
            System.out.println(c.get(i).toString());
        }
    }
    public Train getTrain(int index) {
        if (index < 0 || index >= t.getLength()) {
            return null;
        }

        return t.getTrain(index);
    }

    public TrainClass getTrainClass(Train train,int classId) {
        ArrayList<TrainClass> classes = t.getClass(train);
        if (classes == null) {
            return null;
        }

        for (TrainClass c : classes) {
            if (c.getClassId() == classId) {
                return c;
            }
        }

        return null;
    }
   public Booking bookTicket(String userEmail,Train train,TrainClass trainClass, ArrayList<Passenger> passengers) {

        int count = passengers.size();

        if (trainClass.getAvailSeat() < count) {
            return null;
        }

        double totalAmount = trainClass.getPrice() * count;

        Payment payment = new Payment(totalAmount);

        trainClass.reduceSeats(count);

        Booking booking = new Booking(userEmail,train,trainClass,passengers,totalAmount,payment);

        bookingRepo.save(booking);

        return booking;
    }
    public boolean cancelTicket(int bookingId) {

        Booking booking = bookingRepo.getBooking(bookingId);

        if (booking == null) {
            return false;
        }

        if (booking.getStatus().equals("CANCELLED")) {
            return false;
        }

        int passengerCount = booking.getPassengers().size();

        booking.getTrainClass().increaseSeats(passengerCount);

        booking.cancel();

        return true;
    }
}
