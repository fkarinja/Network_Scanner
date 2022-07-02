package Application.FileWorks;

import Application.InputParser.UserInputParse;
import Application.NetworkDevice.Device;

import java.io.FileWriter;
import java.io.IOException;

public class DeviceExportToTXT {
    /**
     * Method exports UserInputParse.foundDevices devices to a TXT file
     * @param filePath
     */

    public static void exportResultsToTxt(String filePath){

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for(Device device : UserInputParse.foundDevices){
                fileWriter.append(device.toString());
                fileWriter.append("\n");
                Messenger.newMessage("[*] Devices export to TXT successful.");
            }
            fileWriter.close();
        } catch (IOException e) {
            Messenger.newMessage("Log file not found!!!");
        }
    }
}
