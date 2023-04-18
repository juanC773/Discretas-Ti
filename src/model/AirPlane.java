package model;

import java.util.ArrayList;

public class AirPlane {



    private ArrayList<Seat> seats;










    public AirPlane(){

        seats= new ArrayList<>();

        for (int i = 1; i < 16; i++) {

            seats.add(new Seat(1,i));

        }
        for (int i = 16; i <= 32; i++) {

            seats.add(new Seat(2,i));

        }

    }



    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
