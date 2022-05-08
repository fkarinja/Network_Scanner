package UserInterface;

import InputParser.IPAddressWorks;

import java.net.NetworkInterface;
import java.util.Scanner;


public class MainApp {
    // Privatni scanner jer ću ga koristiti više pute za ostale korisničke kontrole, za sada izgleda da mi neće biti potreban System.in osim u glavnom sučelju.
     private static Scanner sc = new Scanner(System.in);
     private static Boolean quit = false;

    public static void main(String[] args) {
       //call Main menu
       menu();


    }
    private static void menu(){

        setCa
        System.out.println("\n============================================================");
        System.out.println("Simple network scanner");
        System.out.println("============================================================\n");


        if (IPAddressWorks.isLAddressistEampty()){
            System.out.println("[*] Current target list is EMPTY!");
        } else {
            IPAddressWorks.listTargets();
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("[*] To add enter targets menu, enter \"ping\" or \"P\"");
        //System.out.println("[*] To add enter targets menu, enter \"ping\"");
        System.out.println("[*] To quit enter \"quit\" or  \"Q\"");

        System.out.println();
        while (quit == false){
            String input = sc.nextLine();
            input = input.trim().toLowerCase();
            if(input.equals("ping") || input.equals("p")){
                getAddressInput();
            } else if(input.equals("quit") || input.equals("q")){
                System.out.println("[*]");
                quit = true;
            }
        }
    }

    private static void getAddressInput(){
        System.out.println("------------------------------------------------------------");
        System.out.println("IP address ie. => 192.168.1.1");
        System.out.println("IP address range ie. => 192.168.1.1-255");
        System.out.println("Please enter IP address or IP address range.");

        String address = sc.nextLine();

        IPAddressWorks.initialParser(address);
        cleanScreen();
        menu();
    }

    private static void cleanScreen(){
        for( int i = 0; i <= 20; i++){
            System.out.println("\n");
        }
    }


}
