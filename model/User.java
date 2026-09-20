package model;
public class User{
    protected static int start =1;
    protected int userId;
    protected String userName;
    protected String email;
    protected String password;
    protected String phno;
 
    public User(String userName, String email, String password, String phno){
        this.userId = start++;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phno = phno;
    }
 
    public String getEmail(){
        return this.email;
    }
 
    public String getPass(){
        return this.password;
    }

}