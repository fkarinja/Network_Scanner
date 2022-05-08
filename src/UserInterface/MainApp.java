package UserInterface;

import InputParser.IPAddressWorks;

import java.util.Scanner;

public class MainApp {
    // Privatni scanner jer ću ga koristiti više pute za ostale korisničke kontrole, za sada izgleda da mi neće biti potreban System.in osim u glavnom sučelju.
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Main menu
        System.out.println("============================================================");
//        System.out.println("IP address ie. => 192.168.1.1");
//        System.out.println("IP address range ie. => 192.168.1.1-255");
//        System.out.println("Please enter IP address or IP address range.");

        //String address = sc.nextLine();
        String address = "192.168.8.1-255";
        IPAddressWorks.initialParser(address);


    }
}
