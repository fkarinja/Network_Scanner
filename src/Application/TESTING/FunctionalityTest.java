package Application.TESTING;

import Application.TraceRoute.TraceRoute;
import Application.UserInterface.MainWindow;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FunctionalityTest {

    public static void main(String[] args) {

//        /**
//         * Samo za potrebe testiranja funkcionalnosti
//         */
//        String testIPAddress = "8.8.8.8";
//
//        UserInputParse.initialParser(testIPAddress);
//        UserInputParse.initialParser("1.1.1.1");
//        System.out.println(UserInputParse.foundDevices);
//
//        DeviceToFile.deviceToFile("src/Application/BinStorage/FoundDevices.bin");
////        DeviceToFile.deviceToFile("src/Application/BinStorage/FoundDevices1.bin");
//
//        System.out.println(UserInputParse.foundDevices);


//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainWindow();
//
//            }
//        });

        InetAddress asd = null;
        try {
            asd = InetAddress.getByName("google.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//        TraceRoute.traceRoute(asd);

    }



}
