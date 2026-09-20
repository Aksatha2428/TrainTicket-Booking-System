package repository;
import model.User;
import java.util.*;
public class UserRepo {
    private HashMap<String, User> uCollection = new HashMap<>();

    public void save(User user) {
        uCollection.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return uCollection.get(email);
    }
}