package model;

import java.util.ArrayList;


public class AirPlane {



    private ArrayList<Seat> seats;



    public void entranceOfPeopleToThePlane(Heap heap){





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
    }



    int rowCounter=2;
    int counter=0;
    public void departureOfPassengersFromThePlane(){

        Stack stackToGetOutPassengersWindow= new Stack();
        Stack stackToGetOutPassengersAisle=new Stack();

      //Acomoda a los pasajeros en pilas para salir de la manera más adecuada
        for (int i = seats.size()-1; i >= 0 ; i--) {

            if(seats.get(i).getPassenger()!=null) {

                //Verifica si es de ventana
                if (seats.get(i).getPassenger().getSeat().getTypeOfseat()==1) {


                    stackToGetOutPassengersWindow.push(seats.get(i).getPassenger().getSeat().getNumberOfSeat());
                    seats.set(i,null);

                } // Se infiere que es de pasillo
                else {

                    stackToGetOutPassengersAisle.push(seats.get(i).getPassenger().getSeat().getNumberOfSeat());
                    seats.set(i,null);
                }
            }
        }


        //Saca a los pasajeros
        for (int i = 0; i < seats.size(); i++) {




            if(counter <2){

                Node passenger=stackToGetOutPassengersAisle.pop();
                System.out.println("The passenger of the seat : "+passenger.getKey()+" who was sitting next to the aisle, has left the plane.");



                counter++;
            }else {

                Node passenger=stackToGetOutPassengersWindow.pop();
                System.out.println("The passenger of the seat:  "+passenger.getKey()+" who was sitting next to the window, has left the plane");
                counter++;
            }

            if(counter==4){

                if(rowCounter<=8) {

                    System.out.println("\n Now the passengers in row "+rowCounter+ " are leaving the plane: \n");
                    rowCounter++;
                }

                counter=0;
            }



        }


    }




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
