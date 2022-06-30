package Application.PortWorks;

import Application.NetworkDevice.Device;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PortScan {

    /**
     * Tries to establish contact with device on a specific port
     * @param port      Port to establish connection on
     * @param device    Device to establish connection with
     */

    public static void portScan(int port, Device device) {

        Socket socket = new Socket();
        int timeout = 100;

        SocketAddress socketAddress= new InetSocketAddress(device.getIpAddress(), port);

        try {
            socket.connect(socketAddress, timeout);
            device.addOpenPorts(port);
            socket.close();
        } catch (IOException e) {
        }

    }

}
