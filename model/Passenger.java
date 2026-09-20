package model;

public class Passenger {

    private static int start = 1;

    private int passengerId;
    private String name;
    private int age;
    private String gender;

    public Passenger(String name, int age, String gender) {
        this.passengerId = start++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String toString() {
        return passengerId + "    " +name + "    " +age + "    " +gender;
    }
}