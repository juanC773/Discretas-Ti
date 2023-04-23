package model;

import java.util.ArrayList;
import java.util.Collections;

import dataStuctures.Heap;
import dataStuctures.Node;
import dataStuctures.Queue;
import dataStuctures.Stack;


public class AirPlane {


    //Seats of the airplane
    private ArrayList<Seat> seats;


    /**
     * name: entranceOfPeopleToThePlane
     * people enter the plane
     * @param heap contains the first class people
     * @param queue contains people in order of arrival
     */
    public void entranceOfPeopleToThePlane(Heap heap, Queue queue){



        boolean confirm=true;

        //Ingreso por prioridad.
        while (heap.size() > 0 & confirm ) {


            Passenger passenger = (Passenger) heap.poll();

             if (passenger!=null) {

                 //Cuando ingresa cada pasajero por su prioridad, se va ubicando en su debido asiento.
                seats.get(passenger.getSeat().getNumberOfSeat()-1).setPassenger(passenger);

            }else {
                 confirm=false;
             }


        }

        //ingreso por llegada
        while (!queue.isEmpty()) {

            Passenger passenger = (Passenger) queue.dequeue();

            //Cuando ingresa cada pasajero por su orden de llegada, se va ubicando
            seats.get(passenger.getSeat().getNumberOfSeat()-1).setPassenger(passenger);

        }




    }


    /**
     * name: departureOfPassengersFromThePlane
     * Take the passengers off the plane.
     */
    public void departureOfPassengersFromThePlane(){

        int counter=0;
        int counterRow=2;

        Stack stackToGetOutPassengers= new Stack();

        //Calcula la prioridad de salida
        calculatePriorityToGetOut();

        //Acomoda a las sillas segun su prioridad
        Collections.sort(seats);

        //Agrega a la pila de salida:
        for (int i = 0; i < seats.size(); i++) {

            stackToGetOutPassengers.push(seats.get(i).getPassenger().getSeat().getNumberOfSeat());
        }


        //Saca a los pasajeros
        while (!stackToGetOutPassengers.isEmpty()){
            Node passenger=stackToGetOutPassengers.pop();

            System.out.println("The passenger of the seat: "+passenger.getKey()+" has left the plane.");
            counter++;
            //counter=6 significa que ha terminado de recorrer una fila y counterRow<9 para que no se imprima un # de fila inexistente
            if(counter==6 & counterRow<9){
                System.out.println("\nNow the passengers of row #"+counterRow+ " leave the plane:\n");
                counterRow++;
                counter=0;
            }


        }

    }

    /**
     *name: calculatePriorityToGetOut
     *calculates the priority for the exit, taking into account the type of chair and the row.
     */
    public void calculatePriorityToGetOut(){

        //A los de las ventanas no se les suma puntos de prioridad para salir

        for (int i = seats.size()-1; i >= 0 ; i--){

            //Prioridad para el tipo de silla
            if(seats.get(i).getTypeOfseat()==2){ //2= mitad
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+25);

            } else if (seats.get(i).getTypeOfseat()==3) {//3=pasillo

                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+50);
            }
            //Prioridad para la fila
            if(seats.get(i).getNumberOfRow()==1){
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+10000);

            } else if (seats.get(i).getNumberOfRow()==2) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+900);
            }
            else if (seats.get(i).getNumberOfRow()==3) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+800);
            }
            else if (seats.get(i).getNumberOfRow()==4) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+700);
            }
            else if (seats.get(i).getNumberOfRow()==5) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+600);
            }
            else if (seats.get(i).getNumberOfRow()==6) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+500);
            }
            else if (seats.get(i).getNumberOfRow()==7) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+400);
            }else if (seats.get(i).getNumberOfRow()==8) {
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+300);
            }


        }

    }


    /**
     * Constructor
     */
    public AirPlane() {
        seats = new ArrayList<>();

        int numOfRow=1;
        int tyPeOfSeat=1;


        for (int i = 1; i <= 48; i++) {

           if(tyPeOfSeat==1){

               seats.add(new Seat(1,i,numOfRow));
               tyPeOfSeat++;

           }else if(tyPeOfSeat==2){
               seats.add(new Seat(2,i,numOfRow));
               tyPeOfSeat++;
           } else if (tyPeOfSeat==3) {

               seats.add(new Seat(3,i,numOfRow));
               tyPeOfSeat++;

           } else if (tyPeOfSeat==4) {

               seats.add(new Seat(3,i,numOfRow));
               tyPeOfSeat++;
           }
           else if (tyPeOfSeat==5) {

               seats.add(new Seat(2,i,numOfRow));
               tyPeOfSeat++;
           } else if (tyPeOfSeat==6) {

               seats.add(new Seat(1,i,numOfRow));
               tyPeOfSeat=1;
               numOfRow++;
           }


        }

    }



    //Getter and setters

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
