package InputParser;

import com.sun.jdi.InvalidLineNumberException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class IPAddressWorks {
    private static ArrayList<InetAddress> inetAddressList = new ArrayList<InetAddress>();

    public static void initialParser(String address){
        System.out.println("[*] Starting IP address enumeration ...");
        //System.out.println("[*] Replying only with IP live addresses. "); //iako je neuredno treba biti feedback da li je dostupno
        //jer može proći puno vremena ako veći dio mreže nije dostupan.

        if(address.contains("-")){
            dashSeparatorIPAddressList(address);
        } else {
            singleIPAdressIsReacable(address);
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
            singleIPAdressIsReacable(singleIP);
        }


    }

    private static void singleIPAdressIsReacable(String stringAddress){

        //System.out.println("[*]");    // Test da li ulazi ovdje.

        try {
            // u ovom dijelu samo pulim listu, nakon toga ide u klasu koja će otvoriti

            InetAddress address = InetAddress.getByName(stringAddress);
            if (address.isReachable(50)){
                System.out.println("=> : " + address.getHostAddress() + " IS reacheable!");
                System.out.println("Adding to the list of potential targets.");

                inetAddressList.add(address);
            } else {
                System.out.println("=>  " + address.getHostAddress() + " no reply.");
            }


        //default exceptions koje sam "hendlao"
        } catch (UnknownHostException e) {
            System.out.println("Parsing the IP address returned an error. Please check your input!");
        } catch (IOException e) {
            System.out.println("Something went wrong trying to contact the IP address you provided.");
            System.out.println("Are you connected to any networks?");
        }


    }

    public static boolean isLAddressistEampty(){
        return inetAddressList.isEmpty();
    }


    public static void listTargets(){
        System.out.println("[*] Potential targets in the list:");
        for(InetAddress addr : inetAddressList){
            System.out.print("IP address: ");
            System.out.println(addr.toString());
        }
    }


}
