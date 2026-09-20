package view;
import controller.UserController;
import view.TrainView;
import model.User;
import java.util.*;
import repository.TrainRepo;
import model.Train;
import model.TrainClass;
import model.Passenger;
import java.util.ArrayList;
import model.Booking;
import model.Passenger;
public class UserView{
    static UserController uc;
    static Scanner sc = MainView.sc;
    static String currentUserEmail;
    public UserView(TrainRepo trainRepo){
        uc = new UserController(trainRepo);
    }
    public static void showMenu(){
        while(true){
            System.out.println("===USER MENU===");
            System.out.printf(" 1. User Login\n 2.Register User\n 3.Exit System\n\n");
            int op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    Login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;
            }
        }
    }
    
    public static void Login(){
        System.out.print("Enter email id: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

            if(uc.Login(email,pass)){
                currentUserEmail = email;
                showLoginMenu();
            }
    }
    
    public static void register(){
        System.out.print("Enter username: ");
        String un = sc.nextLine();

        System.out.print("Enter Phone number: ");
        String ph = sc.nextLine();

        System.out.print("Enter email id: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if(uc.containsUser(email)){
            System.out.println("User registered already... Login to continue");
        }
        else{
            uc.createUser(un,email,pass,ph);
            System.out.print("User Created Successfully\n\n");
        }
    }

    public static void showLoginMenu() {

        while (true) {

            System.out.println();
            System.out.println("==== LOGIN MENU ====");
            System.out.println();
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    bookTicket();
                    break;

                case 2:
                    cancelTicket();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice.");
           }
        }
    }


    public static void bookTicket() {

        System.out.println();
        System.out.println("========== BOOK TICKET ==========");

        uc.showTrain();

        System.out.print("Enter Train Id: ");
        int trainIndex = sc.nextInt();
        sc.nextLine();

        Train train = uc.getTrain(trainIndex);

        if (train == null) {
            System.out.println("Invalid train id.");
            return;
        }

        System.out.println();
        uc.showClass(trainIndex);

        System.out.print("Enter Class ID: ");
        int classId = sc.nextInt();
        sc.nextLine();

        TrainClass trainClass = uc.getTrainClass(train, classId);

        if (trainClass == null) {
            System.out.println("Invalid class ID.");
            return;
        }

        System.out.print("Enter Number of Passengers: ");
        int count = sc.nextInt();
        sc.nextLine();

        if (count <= 0) {
            System.out.println("Invalid number of passengers.");
            return;
        }

        if (trainClass.getAvailSeat() < count) {
            System.out.println("Not enough seats available.");
            return;
        }

        ArrayList<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            System.out.println();
            System.out.println("Passenger " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();

            Passenger passenger = new Passenger(name, age, gender);
            passengers.add(passenger);
        }

        double totalAmount = trainClass.getPrice() * count;

        System.out.println();
        System.out.println("========== PAYMENT ==========");
        System.out.println("Number of Passengers : " + count);
        System.out.println("Price per Passenger  : " + trainClass.getPrice());
        System.out.println("Total Amount         : " + totalAmount);

        System.out.print("Confirm payment? (Y/N): ");
        String choice = sc.nextLine();

        if (!choice.equalsIgnoreCase("Y")) {
            System.out.println("Payment cancelled.");
            return;
        }

        Booking booking = uc.bookTicket(currentUserEmail,train,trainClass,passengers);

        if (booking != null) {
            System.out.println();
            System.out.println("Payment successful!");
            System.out.println("Booking successful!");

            showBooking(booking);
        }
}

public static void showBooking(Booking booking) {

    System.out.println();
    System.out.println("========== BOOKING ==========");

    System.out.println("Booking ID     : " + booking.getBookingId());
    System.out.println("User Email     : " + booking.getUserEmail());
    System.out.println("Train          : " + booking.getTrain());
    System.out.println("Class          : " + booking.getTrainClass().getClassName());
    System.out.println("Total Amount   : " + booking.getTotalAmount());
    System.out.println("Booking Status : " + booking.getStatus());

    System.out.println();
    System.out.println("Passenger ID    Name    Age    Gender");

    for(Passenger p : booking.getPassengers()) {
        System.out.println(p);
    }

    System.out.println();
    System.out.println("Payment ID    Amount    Status");
    System.out.println(booking.getPayment());

    System.out.println("=============================");
}


public static void cancelTicket() {

    System.out.println();
    System.out.println("========== CANCEL TICKET ==========");

    System.out.print("Enter Booking ID: ");
    int bookingId = sc.nextInt();
    sc.nextLine();

    boolean cancelled = uc.cancelTicket(bookingId);

    if (cancelled) {
        System.out.println();
        System.out.println("Booking cancelled successfully.");
        System.out.println("Seats have been restored.");
        System.out.println("Payment has been refunded.");
    } else {
        System.out.println();
        System.out.println("Invalid booking ID or booking already cancelled.");
    }
}
}