package Application.IPScanner;

import Application.InputParser.UserInputParse;
import Application.FileWorks.Messenger;
import Application.NetworkDevice.Device;
import Application.PortWorks.InitialiseCommonPortScan;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPPing {

    /**
     * Based on input string, this method tries to create InnetAdress and checks if it is available
     * @param stringAddress String containing supposed address
     */

    public static void singleIPAddressIsActive(String stringAddress){

        try {
            InetAddress address = InetAddress.getByName(stringAddress);
            boolean exists = false;

            for (Device device : UserInputParse.foundDevices){
                if(device.getIpAddress().toString().equals(address.toString())){
                    exists = true;
                }
            }

            if(!exists){
                if (address.isReachable(500)){
                    Messenger.newMessage("[*] IP address : " + address.getHostAddress() + " IS reachable!");
                    Device device = new Device(address);
                    device.setCanonicalName(address.getCanonicalHostName());
                    UserInputParse.foundDevices.add(device);

                    InitialiseCommonPortScan.cycleThroughCommonPorts(device);
                    exists = false;

                } else {
                    Messenger.newMessage("[!] IP address " + address.getHostAddress() + " no reply.");
                }
            } else if(exists) {
                Messenger.newMessage("[!] IP address has already been scanned!");
                exists = false;
            }





            //Default exceptions handled
        } catch (UnknownHostException e) {
            Messenger.newMessage("[!] Parsing the IP address returned an error. Please check your input!");
        } catch (IOException e) {
            Messenger.newMessage("[!] Something went wrong trying to contact the IP address you provided.");
            Messenger.newMessage("[!] Are you connected to any networks?");
        }
    }
}
