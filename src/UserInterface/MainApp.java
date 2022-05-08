package UserInterface;

import java.util.Scanner;

public class MainApp {
    // Privatni scanner jer ću ga koristiti više pute za ostale korisničke kontrole, za sada izgleda da mi neće biti potreban System.in osim u glavnom sučelju.
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Main menu
        System.out.println("============================================================");
        System.out.println("Please enter IP address or IP address range.");
        System.out.println("IP address ie. => 192.168.1.1");
        System.out.println("IP address range ie. => 192.168.1.0/32 => 192.168.1.1-255");


    }
}
