package model;
public class Admin extends User{
    
     static private int privacyKey = 789;
     public Admin(String userName, String email, String password, String phno) {
        super(userName, email, password, phno);
      }
     public static int getPrivacyKey(){
        return privacyKey;
     }
}