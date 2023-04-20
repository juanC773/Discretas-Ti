package model;

public class Seat {


    //seat==1 es ventana, int==2 es pasillo
    private int typeOfseat;

    private int numberOfSeat;

    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat(int seat, int numberOfSeat) {
        this.typeOfseat = seat;
        this.numberOfSeat = numberOfSeat;
    }

    public int getTypeOfseat() {
        return typeOfseat;
    }

    public void setTypeOfseat(int typeOfseat) {
        this.typeOfseat = typeOfseat;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }
}
