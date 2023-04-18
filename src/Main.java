import java.io.IOException;
import java.util.Scanner;

import model.*;

public class Main {


    static PassengerList objPassengerList= new PassengerList();
    public static void main(String[] args) throws IOException {


        //Cargar la informacion


        objPassengerList.load();
        AirLineController controller=new AirLineController();

        Scanner lector = new Scanner(System.in);

        int passengersToMoment=1;
        while(true){
            System.out.println(
                    """
                            
                            Welcome To The Airline.
                            1. Show passengers expected.
                            2. A passenger arrives.
                            3. Show the way passengers are going to enter due to their priority.
                            4. Subir a la gente al avion
                            5. Salir
                            """
            );
            int option = Integer.parseInt(lector.nextLine());
            switch (option){


                case 1:

                    objPassengerList.show();
                    break;

                case 2:

                    controller.arrivalOfpassengers();
                    objPassengerList.save();

                    if(passengersToMoment<=objPassengerList.getPassengerList().size()){
                        System.out.println("have arrived: "+passengersToMoment+"/"+objPassengerList.getPassengerList().size()+" passengers");
                        passengersToMoment++;
                    }

                    break;

                case 3:
                    controller.showHeap(passengersToMoment);
                    break;

                case 4:
                    controller.getPeopleOnthePlane(passengersToMoment);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }

    }


}
