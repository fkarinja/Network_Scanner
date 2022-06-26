package Application.IPScanner;

import Application.InputParser.IPAddressWorks;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class IPPing {

    //Samo pinganje
    public static void singleIPAdressIsReacable(String stringAddress){

        try {
            // u ovom dijelu samo punim listu, nakon toga ide u klasu koja će otvoriti
            InetAddress address = InetAddress.getByName(stringAddress);
            if (address.isReachable(50)){
                System.out.println("=> : " + address.getHostAddress() + " IS reacheable!");
                System.out.println("Adding to the list of potential targets.");

                IPAddressWorks.inetAddressList.add(address);
            } else {
                System.out.println("=>  " + address.getHostAddress() + " no reply.");
            }


            //default exceptions koje sam "hendlao"
        } catch (UnknownHostException e) {
            System.out.println("[!] Parsing the IP address returned an error. Please check your input!");
        } catch (IOException e) {
            System.out.println("[!] Something went wrong trying to contact the IP address you provided.");
            System.out.println("[!] Are you connected to any networks?");
        }
    }
}
