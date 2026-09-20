package view;
import repository.TrainRepo;
import model.Train;
import model.TrainClass;
import java.util.*;
public class TrainView{
    public static void showTrain(TrainRepo t){
        System.out.println();
        System.out.println("Viewing Available Trains...");
        System.out.println();
        int n = t.getLength();
        System.out.println("ID    TrainNo     Starts From     Destination     Departure Time    Arrival time");
        for(int i=0; i<n;i++){
            System.out.println(i+"      "+t.print(i));
        }
        System.out.println();
    }
    public static void showClass(TrainRepo t, int id){
        Train train = t.getTrain(id);
        if(train==null){
            System.out.println("No train found for the particular index");
            return;
        }
        ArrayList<TrainClass> c = t.getClass(train);
        System.out.println("Class Id    Class Name      Total Capacity      Available seats     Price per seat");
        for(int i=0;i<c.size();i++){
            System.out.println(c.get(i).toString());
        }
    }
}