package Application.UserInterface;

import Application.IPScanner.IPPing;
import Application.InputParser.UserInputParse;

public class FunctionalityTest {

    public static void main(String[] args) {
        /**
         * Samo za potrebe testiranja funkcionalnosti
         */
        String testIPAddress = "10.100.1.254";
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


        UserInputParse.initialParser(testIPAddress);
        System.out.println(UserInputParse.foundDevices);



    }



}
