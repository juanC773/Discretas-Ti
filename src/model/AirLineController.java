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


    //Cuando lleguen, los 10 primeros reciben un poco de prioridad por llegar primero




    AirPlane airPlane=new AirPlane();
    Heap heap=new Heap(32);







    public void arrivalOfpassengers() throws IOException {


        Passenger passenger=randomPassenger();
        if(passenger==null){
            System.out.println("All the passengers have arrived");
        }else {

            calculatePriority(passenger);
            System.out.println("the passenger will give his identification:");
            System.out.println("Hi, mi name is: " + passenger.getName() + " " + passenger.getLastName() + ", my id is: " + passenger.getNatID());



            heap.add(passenger);





            }


        }


    public void showHeap() {

        System.out.println("Pasajeros en orden de prioridad:");


        boolean confirm=true;

        while (heap.size() > 0 & confirm ) {

            Passenger nextPassenger = (Passenger) heap.poll();

            if(nextPassenger==null){
                 System.out.println("Es toda la lista");
                 confirm=false;
            } else if (nextPassenger!=null) {
                System.out.println(nextPassenger.getName() + " - Prioridad: " + nextPassenger.getPriority());

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
        if(passenger.getSeat().getSeat()%2==0){
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


}
