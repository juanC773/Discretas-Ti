package model;
import dataStuctures.Heap;
import dataStuctures.Queue;
import model.enums.PassengerCategory;
import model.enums.SpecialCase;

import java.util.Random;
import java.io.IOException;

public class AirLineController {


    private PassengerList passengerList;


    /**
     * constructor
     */
    public AirLineController() {
        passengerList = new PassengerList();
        try {
            passengerList.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * name: prints "The shape of the plane"
     */
    public void airPlaneStructure(){

        System.out.println(


                """
                                
                             
                                        aisle         [Exit                        
                        |               ''''               |       SON 12 DE PRIMERA CLASE        
              row:1     |   [1] [2] [3] '''' [4] [5] [6]   |       16 v, P, M
              row:2     |   [7] [8] [9] '''' [10][11][12]  |
              row:3     |  [13][14][15] '''' [16][17][18]  |
              row:4     |  [19][20][21] '''' [22][23][24]  |
              row:5     |  [25][26][27] '''' [28][29][30]  |
              row:6     |  [31][32][33] '''' [34][35][36]  |
              row:7     |  [37][38][39] '''' [40][41][42]  | } First Class
              row:8     |  [43][44][45] '''' [46][47][48]  | } First Class
                        |                                  |
                        |               ⬇                  |  
                        |             cockpit              |
                        """
        );

    }



    //Obj
    AirPlane airPlane=new AirPlane();
    Heap heap=new Heap(airPlane.getSeats().size());
    Heap heapToSeeInsideTheAirplane=new Heap(heap.size());

    Queue queueToEntry=new Queue();

    Queue queueToSeeInsideTheAirplane=new Queue();


    /**
     * name: arrivalOfPassengers
     * Simulates the arrival of passengers.
     * @throws IOException
     */
    int counterArrival=1;
    public void arrivalOfpassengers() throws IOException {



        //Random para que llegue cualquier pasajero
        Passenger passenger=randomPassengerArrive();

        if(passenger==null){
            System.out.println("All the passengers have arrived, ready to board!");

        }else{


            if((passenger.getPassengerCategory()==PassengerCategory.FirstClass)){

                //Envia a calcular las prioridades solo de los pasajeros de primera clase
                calculatePriority(passenger);
                //Agrega al monticulo para ordenarlos de más a menos prioridad.
                heap.add(passenger);


                //Le agrega a un nuevo monticulo para ver a las personas dentro del avion
                heapToSeeInsideTheAirplane.add(passenger);

            }else {

                //agrega a la cola segun la llegada
                queueToEntry.enqueue(passenger);

                //Agrega a otra queue para ver a las personas dentro del avion
                queueToSeeInsideTheAirplane.enqueue(passenger);



            }

            //Imprime los datos del pasajero que llega

            System.out.println("the passenger will give his identification:");
            System.out.println("Hi, mi name is: " + passenger.getName() + " " + passenger.getLastName() + ", my id is: " + passenger.getNatID());

            //Esto indica que solo se les dara un poco mas de prioridad a  los 10 primeros pasajeros en llegar
            if(counterArrival<=10){
                System.out.println("\n(The passenger has received more priority for arriving early)");
                passenger.setPriority(passenger.getPriority()+100);
            }

                counterArrival++;
            }
        }


    /**
     * name:showEntry
     * Shows the list of the order to enter the plane, according to your priority and then follow your order of arrival
     * @param allPassengers passengers who have arrived so far
     */
    public void showEntry(int allPassengers) {

        int planeTicketNumber=1;

        allPassengers--;

        //Imprime cuantos pasajeros hacen falta para poder usar el método
        if(allPassengers<airPlane.getSeats().size()){

            int totalPassengers=heap.size()-allPassengers;
            System.out.println("You can't board yet, not all the passengers have arrived, missing: "+totalPassengers+" passengers");

        }else {

            System.out.println("Passengers in order of priority:\n");

            boolean confirm = true;

            //Imprime el monticulo de prioridad
            while (heap.size() > 0 & confirm ) {

                Passenger passenger = (Passenger) heap.poll();

                if (passenger == null) {

                    System.out.println("All first-class passengers, organized by priority, have gone up.\n");
                    confirm = false;
                } else {

                    System.out.println("Name: " + passenger.getName() +" Last name: "+passenger.getLastName() +" --Priority: " + passenger.getPriority() + " --Enter of number: " + planeTicketNumber + "\n---------");
                    planeTicketNumber++;
                }


            }
            //Imprime la cola de prioridad por orden de llegada
            while (!queueToEntry.isEmpty()) {

                Passenger passenger = (Passenger) queueToEntry.dequeue();
                System.out.println("Name: "+passenger.getName()+" Last Name: "+passenger.getLastName()+" --Enter of number: "+planeTicketNumber+"\n---------");
                planeTicketNumber++;

            }
            System.out.println("All passengers have boarded the plane");


        }



    }


    /**
     * name: getPeopleOnThePlane
     * The objective of the method is for each passenger to be accommodated in their respective seat after boarding the plane.
     */
    public void getPeopleOnthePlane() {

            //Acomoda a los pasajeros en sus respectivas sillas luego de entrar por orden de prioridad y orden de llegada

            airPlane.entranceOfPeopleToThePlane(heapToSeeInsideTheAirplane,queueToSeeInsideTheAirplane);

            System.out.println("After having entered with their due priority and order of arrival, they have been located in their respective seats: \n");

            //Recorre Cada silla para verificar que los pasajeros se sentaron en sus respectivas sillas
            for (int i = 0; i < airPlane.getSeats().size(); i++) {


                if (airPlane.getSeats().get(i).getPassenger() != null) {
                    System.out.println("The seat number is: " + airPlane.getSeats().get(i).getNumberOfSeat() + ", the name of the passenger is: " + airPlane.getSeats().get(i).getPassenger().getName() + " According to his ticket, your seat is:" + airPlane.getSeats().get(i).getPassenger().getSeat().getNumberOfSeat()+"\n ------------");
                }
            }


        }


    /**
     * name: randomPassengerArrive
     * Simulates that passengers arrive randomly
     * @return Returns the passenger who arrives randomly
     * @throws IOException
     */
    public Passenger randomPassengerArrive() throws IOException {

        Random random = new Random();

        while (passengerList.getPassengerList().size()>0){

            int randomNumber = random.nextInt(passengerList.getPassengerList().size());
            Passenger passenger=passengerList.getPassengerList().get(randomNumber);
            passengerList.getPassengerList().remove(randomNumber);
            passengerList.save();
            return passenger;

        }
        return null;
    }




    public void calculatePriority(Passenger passenger)  {

        int quantityToPriority=0;

        //si es primera clase, Las millas, La condicion especial, Llegada de primero, numero de asiento, si su asiento es ventana, en la mitad o pasillo

        //primera Clase
        if (passenger.getPassengerCategory()== PassengerCategory.FirstClass){
            quantityToPriority+=1000;
        }


        //Miles
        quantityToPriority+=calculateMiles(passenger.getMiles());



        //Embarazada primero, discapacitado, viejito
        if(passenger.getSpecialCase()== SpecialCase.Pregnancy){
            quantityToPriority+=500;

        } else if (passenger.getSpecialCase()==SpecialCase.Disability){
            quantityToPriority+=450;

        } else if (passenger.getSpecialCase()==SpecialCase.Ancient) {
            quantityToPriority+=400;
        }

        //Prioridad dependiendo el numero de asiento, entre mas lejos su asiento, más prioridad
        if(passenger.getSeat().getNumberOfSeat()>0 && passenger.getSeat().getNumberOfSeat()<=10){
            quantityToPriority+=20;
        } else if (passenger.getSeat().getNumberOfSeat()>10 && passenger.getSeat().getNumberOfSeat()<=20) {
            quantityToPriority+=100;

        } else if (passenger.getSeat().getNumberOfSeat()>20 && passenger.getSeat().getNumberOfSeat()<24) {
            quantityToPriority+=150;

        }else {
            quantityToPriority+=200;
        }

        //si su asiento es en ventana deberia tener mas prioridad al entrar, luego en la mitad y por ultimo en el pasillo.
        if(passenger.getSeat().getTypeOfseat()==1){

            quantityToPriority+=100;

        }//mitad
        else if(passenger.getSeat().getTypeOfseat()==2){
            quantityToPriority+=50;
        }
        //Al de pasillo no se le da mucha prioridad para entrar.




        passenger.setPriority(quantityToPriority);

    }





    /**
     * name: calculateMiles
     * calculates the miles of the passengers, gives them a score depending on the number of miles you have
     * @param miles Number of passenger miles
     * @return Returns the score that depends on the number of miles
     */
    public int calculateMiles(int miles){

        int weighted=0;

        if(miles==0){
            return 0;
        }

        if(miles>0 & miles<=500){

            weighted=100;

        }else if(miles>500 & miles<=1000){
            weighted=150;

        }else if(miles>1000 & miles<=1500){
            weighted=200;

        }else if(miles>1500 || miles<=2000){
            weighted=250;
        }

        return weighted;

    }


    /**
     * name: getThePassengersOut
     * Access the plane class to call the method that takes the passengers out of the plane.
     */
    public void getThePassengersOut(){

        airPlane.departureOfPassengersFromThePlane();

    }


}
