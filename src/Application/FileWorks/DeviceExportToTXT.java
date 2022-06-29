package Application.FileWorks;

import Application.InputParser.UserInputParse;
import Application.NetworkDevice.Device;

import java.io.FileWriter;
import java.io.IOException;

public class DeviceExportToTXT {

    public static void exportResultsToTxt(String filePath){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for(Device device: UserInputParse.foundDevices){
                fileWriter.append(device.toString());
                Messenger.newMessage("[*] Devices export to TXT successful.");
            }
            fileWriter.close();
        } catch (IOException e) {
            Messenger.newMessage("Log file not found!!!");
        }
    }
}
