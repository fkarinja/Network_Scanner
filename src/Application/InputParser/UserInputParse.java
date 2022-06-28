package Application.InputParser;

import Application.IPScanner.IPPing;
import Application.NetworkDevice.Device;

import java.util.ArrayList;


public class UserInputParse {

    public static ArrayList<Device> foundDevices = new ArrayList<>();



    public static void initialParser(String address){
        System.out.println("[*] Starting IP address enumeration ...");

        if(address.contains("-")){
            dashSeparatorIPAddressList(address);
        } else {
            IPPing.singleIPAddressIsActive(address);
        }
    }


    private static void dashSeparatorIPAddressList(String stringAddress){
        //Odvajam zadnji dio ili gornju granicu
        String[] stringAddressSep = stringAddress.split("-");
        int end = Integer.parseInt(stringAddressSep[1]);

        //odvajam donju granicu
        // "." je predefinirani class character, pa da bi ga split uzeo kao char, moram ga unescape-ati
        String[] initAdd = stringAddressSep[0].split("\\.");
        int start = Integer.parseInt(initAdd[3]);

        //Spajam na string bez zadnjeg dijela
        String base = initAdd[0].toString() + "." + initAdd[1].toString()  + "." + initAdd[2].toString()  + ".";


        for(int i = start; i <= end; i++){
            String singleIP = base + i;
            IPPing.singleIPAddressIsActive(singleIP);
        }


    }

}
