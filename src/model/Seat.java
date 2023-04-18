package model;

public class Seat {


    //seat==1 es ventana, int==2 es pasillo
    private int seat;

    private int numberOfSeat;


    public Seat(int seat, int numberOfSeat) {
        this.seat = seat;
        this.numberOfSeat = numberOfSeat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }
}
