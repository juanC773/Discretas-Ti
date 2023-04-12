package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

    public class PassengerList {

        static String folder = "data";

        static String path = "data/data.txt";

        ArrayList<Passenger> passengers;

        public PassengerList() {
            passengers = new ArrayList<Passenger>();
        }


        public ArrayList<Passenger> getPassengerList() {
            return passengers;
        }

        public void setProducts(ArrayList<Passenger> passengers) {
            this.passengers = passengers;
        }


        public void save() throws IOException {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);

            Gson gson = new Gson();
            String data = gson.toJson(passengers);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(data);
            writer.flush();

            fos.close();
        }

        public void load() throws IOException{
            File file = new File(path);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String content = "";
                String line = "";
                while ((line = reader.readLine()) != null) {
                    content += line + "\n";
                }
                System.out.println(content);
                Gson gson = new Gson();
                Passenger[] array = gson.fromJson(content, Passenger[].class);
                passengers.addAll(Arrays.asList(array));
                fis.close();
            } else {
                File f = new File(folder);
                if (!f.exists()) {
                    f.mkdirs();
                }
                file.createNewFile();
            }
        }

        public void show() {
            for (Passenger s : passengers) {
                System.out.println("Passenger name: "+s.getName()+", Last name: "+s.getLastName()+", ID: "+s.getNatID()+", Category Passenger: "+s.getPassengerCategory()+ ", Special case: "+s.getSpecialCase());
            }
        }
    }







