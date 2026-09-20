package view;

import repository.TrainRepo;
import model.Train;
import model.TrainClass;
import java.util.*;
import java.time.LocalTime;
import java.util.Scanner;

public class MainView {

    public static Scanner sc = new Scanner(System.in);
    static TrainRepo trainRepo = new TrainRepo();

    public static void loadDefaultData() {

    // ---------- TRAIN 1 ----------
    Train t1 = new Train(
        12601, "Chennai", "Delhi",
        LocalTime.of(6, 0),
        LocalTime.of(22, 0)
    );

    ArrayList<TrainClass> c1 = new ArrayList<>();
    c1.add(new TrainClass("AC First Class", 20, 100));
    c1.add(new TrainClass("AC 2 Tier", 40, 150));
    c1.add(new TrainClass("Sleeper", 80, 80));

    trainRepo.addList(t1);
    trainRepo.addClassToTrain(t1, c1);


    // ---------- TRAIN 2 ----------
    Train t2 = new Train(
        12602, "Chennai", "Mumbai",
        LocalTime.of(7, 30),
        LocalTime.of(21, 0)
    );

    ArrayList<TrainClass> c2 = new ArrayList<>();
    c2.add(new TrainClass("AC First Class", 20, 120));
    c2.add(new TrainClass("AC 2 Tier", 40, 50));
    c2.add(new TrainClass("Sleeper", 80, 180));

    trainRepo.addList(t2);
    trainRepo.addClassToTrain(t2, c2);


    // ---------- TRAIN 3 ----------
    Train t3 = new Train(
        12603, "Chennai", "Bangalore",
        LocalTime.of(8, 0),
        LocalTime.of(14, 0)
    );

    ArrayList<TrainClass> c3 = new ArrayList<>();
    c3.add(new TrainClass("AC Chair Car", 40, 150));
    c3.add(new TrainClass("Chair Car", 80, 190));
    c3.add(new TrainClass("General", 120, 40));

    trainRepo.addList(t3);
    trainRepo.addClassToTrain(t3, c3);


    // ---------- TRAIN 4 ----------
    Train t4 = new Train(
        12604, "Chennai", "Kolkata",
        LocalTime.of(9, 0),
        LocalTime.of(23, 0)
    );

    ArrayList<TrainClass> c4 = new ArrayList<>();
    c4.add(new TrainClass("AC First Class", 20, 100));
    c4.add(new TrainClass("AC 2 Tier", 40, 250));
    c4.add(new TrainClass("Sleeper", 80, 120));

    trainRepo.addList(t4);
    trainRepo.addClassToTrain(t4, c4);


    // ---------- TRAIN 5 ----------
    Train t5 = new Train(
        12605, "Chennai", "Hyderabad",
        LocalTime.of(10, 30),
        LocalTime.of(19, 0)
    );

    ArrayList<TrainClass> c5 = new ArrayList<>();
    c5.add(new TrainClass("AC Chair Car", 40, 123));
    c5.add(new TrainClass("Chair Car", 80, 140));
    c5.add(new TrainClass("General", 120, 90));

    trainRepo.addList(t5);
    trainRepo.addClassToTrain(t5, c5);
}
    public static void welcome() {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       TRAIN TICKET BOOKING SYSTEM       ");
            System.out.println("========================================");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    UserView uv = new UserView(trainRepo);
                    uv.showMenu();
                    break;

                case 2:
                    AdminView av = new AdminView(trainRepo);
                    av.Login();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;
            }
        }
    }
}
