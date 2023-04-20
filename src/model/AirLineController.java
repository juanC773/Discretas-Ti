package model;
import java.util.Random;
import java.io.IOException;

public class AirLineController {


    private PassengerList passengerList;



    public AirLineController() {
        passengerList = new PassengerList();
        try {
            passengerList.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void airPlaneStructure(){

        System.out.println(


                """
                                
                             
                                      aisle         [Exit                        
                        |             ''''                               
              row:1     |     [1] [2] '''' [3]  [4]   | 
              row:2     |     [5] [6] '''' [7]  [8]   |
              row:3     |    [9] [10] '''' [11] [12]  |
              row:4     |   [13] [14] '''' [15] [16]  |
              row:5     |   [17] [18] '''' [19] [20]  |
              row:6     |   [21] [22] '''' [23] [24]  |
              row:7     |   [25] [26] '''' [27] [28]  | } First Class
              row:8     |   [29] [30] '''' [31] [32]  | } First Class
                        |                             |
                        |               ⬇             |  
                        |             cockpit         |
                        """
        );

    }

    //Cuando lleguen, los 10 primeros reciben un poco de prioridad por llegar primero




    AirPlane airPlane=new AirPlane();
    Heap heap=new Heap(airPlane.getSeats().size());
    Heap heapToEnterAirplane=new Heap(heap.size());






    int counterArrival=1;
    public void arrivalOfpassengers() throws IOException {



        Passenger passenger=randomPassenger();
        if(passenger==null){
            System.out.println("All the passengers have arrived, ready to board!");
        }else {

            calculatePriority(passenger);
            System.out.println("the passenger will give his identification:");
            System.out.println("Hi, mi name is: " + passenger.getName() + " " + passenger.getLastName() + ", my id is: " + passenger.getNatID());

            //Esto indica que solo se les beneficiara a los 10 primeros pasajeros en llegar
            if(counterArrival<=10){
                System.out.println("\n(The passenger has received more priority for arriving early)");
                passenger.setPriority(passenger.getPriority()+50);
            }

            counterArrival++;

            heap.add(passenger);

            //Le agrega a un nuevo monticulo para el ingreso del avion
            heapToEnterAirplane.add(passenger);






            }


        }


        int planeTicketNumber=1;
    public void showHeap(int allPassengers) {



        allPassengers--;

        if(allPassengers<32){

            int totalPassengers=heap.size()-allPassengers;
            System.out.println("You can't board yet, not all the passengers have arrived, missing: "+totalPassengers+" passengers");

        }else {

            System.out.println("Passengers in order of priority:\n");


            boolean confirm=true;

            while (heap.size() > 0 & confirm ) {

                Passenger nextPassenger = (Passenger) heap.poll();


                if(nextPassenger==null){
                    System.out.println("All the passengers have boarded the plane.");
                    confirm=false;
                } else if (nextPassenger!=null) {
                    System.out.println("The passenger: "+nextPassenger.getName() +", enter of number: "+planeTicketNumber+ " - Priority: " + nextPassenger.getPriority()+"\n---------");
                    planeTicketNumber++;

                }


            }

        }





    }


    public void getPeopleOnthePlane() {

            //Acomoda a los pasajeros en sus respectivas sillas luego de entrar por orden de prioridad

            airPlane.entranceOfPeopleToThePlane(heapToEnterAirplane);

            System.out.println("After having entered with their due priority, they have been located in their respective seats: \n");

            for (int i = 0; i < airPlane.getSeats().size(); i++) {

                if (airPlane.getSeats().get(i).getPassenger() != null) {
                    System.out.println("The seat number is: " + airPlane.getSeats().get(i).getNumberOfSeat() + ", the name of the passenger is: " + airPlane.getSeats().get(i).getPassenger().getName() + " According to his ticket, your seat is:" + airPlane.getSeats().get(i).getPassenger().getSeat().getNumberOfSeat()+"\n ------------");
                }
            }


        }





    public Passenger randomPassenger() throws IOException {



        Random random = new Random();




        if(passengerList.getPassengerList().size()>0){

            int numeroAleatorio = random.nextInt(passengerList.getPassengerList().size());
            Passenger passenger=passengerList.getPassengerList().get(numeroAleatorio);
            passengerList.getPassengerList().remove(numeroAleatorio);
            passengerList.save();
            return passenger;

        }else {

            return null;
        }
    }




    public void calculatePriority(Passenger passenger)  {

        int quantityToPriority=0;

        //si es primera clase, Las millas, La condicion especial, Llegada de primero, numero de asiento, si su asiento es ventana o pasillo

        //primera Clase
        if (passenger.getPassengerCategory()==PassengerCategory.FirstClass){
            quantityToPriority+=1000;
        }


        //Miles
        quantityToPriority+=calculateMiles(passenger.getMiles());



        //preñada primero, discapacitado, viejito
        if(passenger.getSpecialCase()==SpecialCase.Pregnancy){
            quantityToPriority+=500;

        } else if (passenger.getSpecialCase()==SpecialCase.Disability){
            quantityToPriority+=450;

        } else if (passenger.getSpecialCase()==SpecialCase.Ancient) {
            quantityToPriority+=400;
        }


        if(passenger.getSeat().getNumberOfSeat()>0 && passenger.getSeat().getNumberOfSeat()<=10){
            quantityToPriority+=20;
        } else if (passenger.getSeat().getNumberOfSeat()>10 && passenger.getSeat().getNumberOfSeat()<=20) {
            quantityToPriority+=100;

        } else if (passenger.getSeat().getNumberOfSeat()>20 && passenger.getSeat().getNumberOfSeat()<24) {
            quantityToPriority+=150;

        }else {
            quantityToPriority+=200;
        }

        //si su asiento es en ventana deberia tener mas prioridad al entrar
        if(passenger.getSeat().getTypeOfseat()==1){
            System.out.println("");

            quantityToPriority+=25;
        }else {
            quantityToPriority+=100;
        }




        passenger.setPriority(quantityToPriority);

    }


    //public void sacar gente, aqui importa que salga primero los del pasillo


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




    public void getThePassengersOut(){

        airPlane.departureOfPassengersFromThePlane();

    }


}
