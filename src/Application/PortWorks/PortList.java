package Application.PortWorks;

import Application.FileWorks.Messenger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class PortList {

    public static TreeMap<Integer, String> commonPorts = new TreeMap<Integer, String>();

    /**
     * Reads ports from a csv document, ad fills them into TreeMap to be accessed by other classes
     */


    public static void readCommonPorts(){
        File csv = new File("src/Application/PortWorks/CommonPorts.csv");
        try {
            Scanner sc = new Scanner(csv);
            while (sc.hasNextLine()){
                String portString = sc.nextLine();
                String[] port  = portString.split(",");
                commonPorts.put(Integer.parseInt(port[1]), port[0]);
            }
        } catch (FileNotFoundException e) {
            Messenger.newMessage("File containing common ports not found.");
        }

    }


}
