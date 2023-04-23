package model;

import java.util.ArrayList;
import java.util.Collections;

import dataStuctures.Heap;
import dataStuctures.Node;
import dataStuctures.Queue;
import dataStuctures.Stack;


public class AirPlane {



    private ArrayList<Seat> seats;



    public void entranceOfPeopleToThePlane(Heap heap, Queue queue){


        System.out.println(queue.size());



        boolean confirm=true;

        while (heap.size() > 0 & confirm ) {

            //Ingreso por prioridad.
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





    public void departureOfPassengersFromThePlane(){

        int counter=0;
        int counterRow=2;

        Stack stackToGetOutPassengers= new Stack();

        //Calcula la prioridad de salida
        calculatePriorityToGetOut();


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

            if(counter==6 & counterRow<9){
                System.out.println("\nNow the passengers of row #"+counterRow+ " leave the plane:\n");
                counterRow++;
                counter=0;
            }


        }

    }

    public void calculatePriorityToGetOut(){

        //A los de las ventanas no se les suma puntos de prioridad para salir

        for (int i = seats.size()-1; i >= 0 ; i--){

            //Prioridad para el tipo de silla
            if(seats.get(i).getTypeOfseat()==2){
                seats.get(i).setPriorityToGetOut(seats.get(i).getPriorityToGetOut()+25);

            } else if (seats.get(i).getTypeOfseat()==3) {

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




    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
