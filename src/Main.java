import java.io.IOException;
import java.util.Scanner;

import dataStuctures.Heap;
import model.*;

public class Main {


    static PassengerList objPassengerList= new PassengerList();
    public static void main(String[] args) throws IOException {


        //Cargar la informacion


        objPassengerList.load();
        AirLineController controller=new AirLineController();

        Scanner lector = new Scanner(System.in);

        //Verifica que todos los pasajeros ya han entrado segun su priotidad
        boolean boarding=false;

        //Verifica si los pasajeros ya han abordado para activar la opción poder sacarlos del avión
        boolean boarder=false;

        //Lleva un conteo de los pasajeros que han llegado
        int passengersToMoment=1;
        while(true){
            System.out.println(
                    """
                            
                            Welcome To The Airline.
                            1. Airplane Structure.
                            2. Show passengers expected.
                            3. A passenger arrives.
                            4. Board passengers according to their priority.
                            5. Look at the passengers already located on the plane.
                            6. Get people off the plane.
                            7. Exit.
                            """
            );
            int option = Integer.parseInt(lector.nextLine());
            switch (option){


                case 1:
                        controller.airPlaneStructure();
                    break;

                case 2:

                    objPassengerList.show();
                    break;

                case 3:

                    System.out.println("-----");
                    controller.arrivalOfpassengers();
                    objPassengerList.save();

                    if(passengersToMoment<=objPassengerList.getPassengerList().size()){
                        System.out.println("\n have arrived: "+passengersToMoment+"/"+objPassengerList.getPassengerList().size()+" passengers");
                        passengersToMoment++;
                        System.out.println("-----");
                    }


                    break;

                case 4:
                    controller.showEntry(passengersToMoment);
                    boarding=true;

                    break;

                case 5:

                    if(boarding){
                        controller.getPeopleOnthePlane();
                        boarder=true;
                    }else {
                        System.out.println("You cannot see how the passengers located on the plane have been if you have not yet put them on the plane according to their priority.");

                    }

                    break;

                case 6:

                    if(boarder){
                        System.out.println("Passengers in row #1 are leaving: \n");

                        controller.getThePassengersOut();

                        System.out.println("\n All the passengers have gotten off the plane, the flight has been a success.");
                        System.exit(0);

                    }else {
                        System.out.println("You can't take passengers off the plane if they haven't boarded the plane.");
                    }

                    break;


                case 7:
                    System.exit(0);
                    break;


            }
        }

    }


}
