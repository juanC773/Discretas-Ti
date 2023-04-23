package model;

public class Seat implements Comparable<Seat>{


    //seat==1 es ventana, int==2 es mitad, int 3=pasillo
    private int typeOfseat;

    private int numberOfSeat;

    private int numberOfRow;

    private int priorityToGetOut;

    public int getNumberOfRow() {
        return numberOfRow;
    }


    public Seat(int typeOfseat, int numberOfSeat, int numberOfRow) {
        this.typeOfseat = typeOfseat;
        this.numberOfSeat = numberOfSeat;
        this.numberOfRow = numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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

    public int getPriorityToGetOut() {
        return priorityToGetOut;
    }

    public void setPriorityToGetOut(int priorityToGetOut) {
        this.priorityToGetOut = priorityToGetOut;
    }

    /**
     * name: compareTo
     * Compare from priority to exit
     * @param o the object to be compared.
     * @return returns the criteria
     */
    @Override
    public int compareTo(Seat o) {

        int criterial=this.priorityToGetOut-o.priorityToGetOut;

        return criterial;
    }
}
