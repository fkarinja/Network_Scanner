package Application.FileWorks;

import Application.InputParser.UserInputParse;
import Application.NetworkDevice.Device;

import java.io.*;

/**
 * Class handling Saving objects to a BIN file, and loading
 */

public class DeviceObjectToBIN {

    /**
     * Cycles through and writes objects in UserInputParse.foundDevices to file
     * @param filePath
     */


    public static void deviceToFile(String filePath){
        File file = new File(filePath);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            if(!UserInputParse.foundDevices.isEmpty()){
                for(Device device : UserInputParse.foundDevices){
                    oos.writeObject(device);
                    Messenger.newMessage("[*] Devices saved successfully!");
                }
            } else {
                Messenger.newMessage("[!] Target list is empty, nothing to write to file.");
            }

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            Messenger.newMessage("[!] File for saving not found!");
        } catch (IOException e) {
            Messenger.newMessage("[!] Something went wrong while trying to write to file!");
        }


    }

    /**
     * Loads Objects found in BIN file and loads them into UserInputParse.foundDevices
     * @param filePath
     */

    public static void deviceFromFile(String filePath){
            File file = new File(filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Device device;
                device = (Device) ois.readObject();
                UserInputParse.foundDevices.add(device);
                Messenger.newMessage("[*] Devices read successfully!");
            }



        } catch (EOFException e){

        }catch (FileNotFoundException e) {
            Messenger.newMessage("[!] File for loading not found!");
        } catch (IOException e) {
            Messenger.newMessage("[!] Something went wrong while trying to write to file!");
        } catch (ClassNotFoundException e) {
            Messenger.newMessage("[!] Wrong object type, are you trying to read wrong file?");
        }

    }


}
