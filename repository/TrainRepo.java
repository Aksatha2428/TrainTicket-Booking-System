package repository;
import model.Train;
import java.util.*;
import model.TrainClass;
public class TrainRepo {
    public ArrayList<Train> trainList = new ArrayList<>();
    public HashMap<Train,ArrayList<TrainClass>> tc = new HashMap<>();

    public void addList(Train train){
        trainList.add(train);
    }        

    public int getLength(){
        return trainList.size();
    }

    public String print(int i){
        return trainList.get(i).toString();
    }

    public Train getTrain(int i){
        return trainList.get(i);
    }

    public void removeTrain(int i){
        tc.remove(trainList.get(i));
        trainList.remove(i);
    }
    
    public void addClassToTrain(Train train, ArrayList<TrainClass> c){
        tc.put(train,c);
    }
    public  ArrayList<TrainClass> getClass (Train train){
        return tc.get(train);
    }
}