package model;
import model.enums.*;

public class Passenger implements  Comparable<Passenger>{

    private String name;
    private String lastName;

    private String natID;

    private int age;

    private int miles;

    private PassengerCategory passengerCategory;

    private SpecialCase specialCase;

    private Seat seat;

    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }



    public Passenger(String name, String lastName, String natID, int age, int miles, PassengerCategory passengerCategory, SpecialCase specialCase, Seat seat) {
        this.name = name;
        this.lastName = lastName;
        this.natID = natID;
        this.age = age;
        this.miles = miles;
        this.passengerCategory=passengerCategory;
        this.specialCase=specialCase;
        this.seat=seat;

    }


    public PassengerCategory getPassengerCategory() {
        return passengerCategory;
    }

    public void setPassengerCategory(PassengerCategory passengerCategory) {
        this.passengerCategory = passengerCategory;
    }

    public SpecialCase getSpecialCase() {
        return specialCase;
    }

    public void setSpecialCase(SpecialCase specialCase) {
        this.specialCase = specialCase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNatID() {
        return natID;
    }

    public void setNatID(String natID) {
        this.natID = natID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    /**
     * name: compareTo
     * Compare by priority.
     * @param o the object to be compared.
     * @return returns the criteria to compare
     */
    @Override
    public int compareTo(Passenger o) {

        int criterial=this.getPriority()-o.priority;

        return criterial;
    }
}
