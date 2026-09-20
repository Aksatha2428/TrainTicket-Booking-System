package view;
import java.util.*;
import model.Train;
import controller.AdminController;
import java.time.LocalTime;
import repository.TrainRepo;
class AdminView{
    static AdminController ac;
    static Scanner sc = MainView.sc;

    public AdminView(TrainRepo trainRepo) {
        ac = new AdminController(trainRepo);
    }

    public void Login(){
        System.out.print("Enter Email Id: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        System.out.print("Enter Privacy Key: ");
        int pvt = sc.nextInt();
        sc.nextLine();
        if(ac.Login(email,pass,pvt)){
            showMenu();
        }
        else{
            System.out.println("Login to continue");
        }
    }

    public static void showMenu(){
        while(true){
            System.out.println();
            System.out.print(" 1. Show Trains\n2. Add Train \n3. Remove Train\n4. Exit\n");
            int op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    ac.showTrain();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Enter Train Number: ");
                    int no = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Starting point: ");
                    String src = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = sc.nextLine();
                    System.out.print("Enter Departure time(HH:MM): ");
                    LocalTime st = LocalTime.parse(sc.nextLine());
                    System.out.print("Enter Arrival Time(HH:MM): ");
                    LocalTime end = LocalTime.parse(sc.nextLine());
                    Train t = ac.addTrain(no,src,dest,st,end);
                    System.out.println("Enter the details of classes: ");
                    System.out.println();
                    System.out.print("Enter the number of classes you wish to add: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    ArrayList<String> className = new ArrayList<>();
                    ArrayList<Integer> total = new ArrayList<>();
                    ArrayList<Double> price = new ArrayList<>();
                    for(int i=1;i<=n;i++){
                        System.out.print("Enter Class Name "+i+": ");
                        String s = sc.nextLine();
                        className.add(s);
                        System.out.print("Enter Total Capacity for class "+i+": ");
                        int tot = sc.nextInt();
                        sc.nextLine();
                        total.add(tot);
                        System.out.print("Enter price for " + className.get(i) + ": ");
                        price.add(sc.nextDouble());
                    }

                    sc.nextLine();

                    ac.addClass(className, total, price, t);
                    System.out.println("\n\nTrain added to the list");
                    break;
                case 3:
                    ac.showTrain();
                    System.out.print("\n\n Enter the Train ID you want to remove");
                    int i= sc.nextInt();
                    sc.nextLine();
                    ac.removeTrain(i);
                    break;
                case 4:
                    return;
            }
        }
    }
} 