package Application.UserInterface;

import Application.IPScanner.IPPing;
import Application.InputParser.UserInputParse;
import Application.NetworkDevice.DeviceToFile;

public class FunctionalityTest {

    public static void main(String[] args) {
        /**
         * Samo za potrebe testiranja funkcionalnosti
         */
        String testIPAddress = "8.8.8.8";

        UserInputParse.initialParser(testIPAddress);
        UserInputParse.initialParser("1.1.1.1");
        System.out.println(UserInputParse.foundDevices);

        DeviceToFile.deviceToFile("src/Application/BinStorage/FoundDevices1.bin");
        DeviceToFile.deviceToFile("src/Application/BinStorage/FoundDevices1.bin");

        System.out.println(UserInputParse.foundDevices);


//        InetAddress ipAddress;
//
//        try {
//            ipAddress = InetAddress.getByName(testIPAddress);
//            PortScanner.cycleThroughCommonPorts(ipAddress);
//
//
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }

//        UserInputParse.initialParser(testIPAddress);
//        System.out.println(UserInputParse.foundDevices);
//


//        IPAddressWorks.initialParser();


//        PortList.readCommonPorts();
//        System.out.println(PortList.commonPorts);

//        PortList.readCommonPorts();


    }



}
