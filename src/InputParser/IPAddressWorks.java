package InputParser;

import com.sun.jdi.InvalidLineNumberException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class IPAddressWorks {
    private static ArrayList<InetAddress> inetAddressList = new ArrayList<InetAddress>();

    public static void initialParser(String address){
        if(address.contains("-")){
            dashSeparatorIPAddressList(address);
        } else {
            singleIPAdressIsReacable(address);
        }
    }

    //Ako je separator
    private static void dashSeparatorIPAddressList(String stringAddress){


    }

    private static void singleIPAdressIsReacable(String stringAddress){

        //System.out.println("[*]");    // Test da li ulazi ovdje.
        try {
            // u ovom dijelu samo pulim listu, nakon toga ide u klasu koja će otvoriti
            InetAddress address = InetAddress.getByName(stringAddress);
            if (address.isReachable(50)){
                System.out.println("[*] IP Address: " + address.getHostAddress() + " IS reacheable!");
                System.out.println("[*] Starting Enumeration ...");
                inetAddressList.add(address);
            } else {
                System.out.println("[!] IP address: " + address.getHostAddress() + " is NOT reacheable!");
            }



        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }





}
