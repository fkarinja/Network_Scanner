package Application.NetworkDevice;

import Application.InputParser.UserInputParse;

import java.io.*;

public class DeviceToFile {

    public static void deviceToFile(String filePath){
        File file = new File(filePath);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            if(!UserInputParse.foundDevices.isEmpty()){
                for(Device device : UserInputParse.foundDevices){
                    oos.writeObject(device);
                }
            } else {
                System.out.println("Target list is empty, nothing to write to file.");
            }

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(); //FNF
        } catch (IOException e) {
            e.printStackTrace(); //READ RIGHTS
        }


    }

    public static void deviceFromFile(String filePath){
            File file = new File(filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Device device;
                device = (Device) ois.readObject();
                UserInputParse.foundDevices.add(device);

            }
//            ois.close();
//            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();    //FNF
        } catch (IOException e) {
            e.printStackTrace();    //READ RIGHTS
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
