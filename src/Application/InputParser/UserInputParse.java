package Application.InputParser;

import Application.IPScanner.IPPing;
import Application.NetworkDevice.Device;
import java.util.ArrayList;

/**
 * Class which handles user input, "parses" it, and forwrads it to IPPing class
 */


public class UserInputParse {

    public static ArrayList<Device> foundDevices = new ArrayList<>();

    /**
     * Handles the "parsing" part
     * @param userInput
     */

    public static void initialParser(String userInput){

        if(userInput.contains("-")){
            dashSeparatorIPAddressList(userInput);
        } else {
            IPPing.singleIPAddressIsActive(userInput);
        }
    }

    /**
     * If initial parser concludes user input has a range of IP addresses it is forwarded here to separate and
     * forward single ip address one by one to IPPing
     * @param stringAddress IP range String
     */


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
