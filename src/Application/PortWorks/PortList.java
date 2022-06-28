package Application.PortWorks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class PortList {

    public static TreeMap<Integer, String> commonPorts = new TreeMap<Integer, String>();




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
            System.out.println("File containing common ports not found.");
            System.out.println("Default location is: src/Application/PortWorks/CommonPorts.csv");
            System.out.println("If not found, please replace!");
        }

    }


}
