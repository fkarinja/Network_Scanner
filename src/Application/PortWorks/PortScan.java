package Application.PortWorks;

import Application.NetworkDevice.Device;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PortScan {

    public static void portScan(int port, Device device) {

        Socket socket = new Socket();
        int timeout = 100;

        SocketAddress socketAddress= new InetSocketAddress(device.getIpAddress(), port);

        try {
            socket.connect(socketAddress, timeout);
            device.addOpenPorts(port);
            socket.close();
        } catch (IOException e) {
            System.out.println("Port " + port + " not open, on device " + device.getIpAddress());
        }

    }

//        InetAddress ipAddress =  device.getIpAddress();
//        try {
//            Socket sock = new Socket(ipAddress, port);
//            System.out.println("TCP port: " + port + " alive and available for fun.");
//            sock.close();
//            device.addOpenPorts(port);
//        } catch (IOException e) {
//            System.out.println("Port " + port + " not open!");
//        }


//    public static void portScan(int port, Device device){
//        Socket socket = new Socket();

////        SocketAddress socketAddress = new InetSocketAddress(device.getIpAddress().toString(), port);
//        InetSocketAddress socketAddress = new InetSocketAddress(device.getIpAddress().toString(), port);
////        System.out.println(socketAddress);
//
//        int timeout = 1000;
//
//        try {
//            socket.connect(socketAddress, timeout);
//            socket.close();
//
//            System.out.println("Open: " + port);
//        } catch (IOException e) {
////            System.out.println("Closed " + port);
//            System.out.println(e);
//        }
//    }








}
