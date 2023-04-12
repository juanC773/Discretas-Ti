import java.io.IOException;
import java.util.Scanner;

import model.Passenger;
import model.PassengerCategory;
import model.PassengerList;
import model.SpecialCase;

public class Main {


    static PassengerList objPassengerList= new PassengerList();
    public static void main(String[] args) throws IOException {


        //Cargar la informacion


        objPassengerList.load();

        Scanner lector = new Scanner(System.in);

        while(true){
            System.out.println(
                    """
                            
                            Welcome To The Airline
                            1. Mostrar
                            2. Salir
                            """
            );
            int option = Integer.parseInt(lector.nextLine());
            switch (option){


                case 1:

                    objPassengerList.show();
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }

    }


}
