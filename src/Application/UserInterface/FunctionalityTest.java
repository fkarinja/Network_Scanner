package Application.UserInterface;


import Application.PortWorks.PortList;
import Application.PortWorks.PortScanner;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class FunctionalityTest {

    public static void main(String[] args) {
        /**
         * Samo za potrebe testiranja funkcionalnosti
         */
        String testIPAddress = "192.168.8.1";
        InetAddress ipAddress;

        try {
            ipAddress = InetAddress.getByName(testIPAddress);
            PortScanner.cycleThroughCommonPorts(ipAddress);


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


//        IPAddressWorks.initialParser();


//        PortList.readCommonPorts();
//        System.out.println(PortList.commonPorts);



    }



}
