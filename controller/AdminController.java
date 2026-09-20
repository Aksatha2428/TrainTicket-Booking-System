package controller;
import model.Train;
import model.Admin;
import repository.UserRepo;
import repository.TrainRepo;
import view.TrainView;
import model.TrainClass;
import java.util.*;
import java.time.LocalTime;
public class AdminController{

    private UserRepo userR = new UserRepo();
    TrainRepo t;
    public AdminController(TrainRepo t) {
        this.t = t;
        Admin admin = new Admin("Admin","ad","ad123","0000000000");
        userR.save(admin);
    }
    
    public boolean Login(String email,String pass, int pvt){
        Admin user = (Admin) userR.getUser(email);
        if(user==null){
            System.out.println();
            System.out.println("User not registered");
            System.out.println("Contact administration for further details\n\n");
            return false;
        }
        if(user.getPass().equals(pass)&&pvt==user.getPrivacyKey()){
            System.out.println("Login Successful");
            return true;
        }
        else{
            System.out.println("Invalid Credentials");
            return false;
        }
    }
    public Train addTrain(int trainNo, String src, String dest, LocalTime st, LocalTime end){
        Train train = new Train(trainNo, src, dest, st, end);
        t.addList(train);
        return train;
    }
    
    public void removeTrain(int i){
        t.removeTrain(i);
    }
    
    public void showTrain() {
        TrainView.showTrain(t);
    }

    public void showClass(int id) {
        TrainView.showClass(t, id);
    }
    

    public void addClass(ArrayList<String> className,ArrayList<Integer> totCap,ArrayList<Double> price,Train train){
        ArrayList<TrainClass> list = new ArrayList<>();
        for(int i = 0; i < className.size(); i++) {
            TrainClass c = new TrainClass(className.get(i),totCap.get(i),price.get(i));
            list.add(c);
         }
        t.addClassToTrain(train,list);
    }

}