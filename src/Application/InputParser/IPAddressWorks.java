package Application.InputParser;

import Application.IPScanner.IPPing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class IPAddressWorks {
    public static ArrayList<InetAddress> inetAddressList = new ArrayList<InetAddress>();

    /**
     *
     * @param address
     */

    public static void initialParser(String address){
        System.out.println("[*] Starting IP address enumeration ...");
        //System.out.println("[*] Replying only with IP live addresses. "); //iako je neuredno treba biti feedback da li je dostupno
        //jer može proći puno vremena ako veći dio mreže nije dostupan.

        if(address.contains("-")){
            dashSeparatorIPAddressList(address);
        } else {
            IPPing.singleIPAdressIsReacable(address);
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
            IPPing.singleIPAdressIsReacable(singleIP);
        }


    }



    public static boolean isLAddressListEmpty(){
        return inetAddressList.isEmpty();
    }




}
