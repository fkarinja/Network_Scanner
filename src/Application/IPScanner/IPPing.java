package Application.IPScanner;

import Application.InputParser.UserInputParse;
import Application.NetworkDevice.Device;
import Application.PortWorks.InitialiseCommonPortScan;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPPing {

    //Samo pinganje
    public static void singleIPAddressIsActive(String stringAddress){

        try {
            // Create InetAddress, if it's available, create Object, add to list
            InetAddress address = InetAddress.getByName(stringAddress);
            if (address.isReachable(50)){
                System.out.println("=> : " + address.getHostAddress() + " IS reachable!");
                Device device = new Device(address);
                device.setCanonicalName(address.getCanonicalHostName());
                UserInputParse.foundDevices.add(device);

                InitialiseCommonPortScan.cycleThroughCommonPorts(device);

            } else {
                System.out.println("=>  " + address.getHostAddress() + " no reply.");
            }
            //Default exceptions handled
        } catch (UnknownHostException e) {
            System.out.println("[!] Parsing the IP address returned an error. Please check your input!");
        } catch (IOException e) {
            System.out.println("[!] Something went wrong trying to contact the IP address you provided.");
            System.out.println("[!] Are you connected to any networks?");
        }
    }
}
