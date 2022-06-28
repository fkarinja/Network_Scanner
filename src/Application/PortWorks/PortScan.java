package Application.PortWorks;

import Application.NetworkDevice.Device;

import java.io.IOException;
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

}
