package Application.PortWorks;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Map;

public class PortScanner {

    /**
     * This method tries to connect to specified InetAddress obj -> TCP port to see if it is open
     * TCP port ONLY!!!!
     * Influenced by: https://stackoverflow.com/questions/434718/sockets-discover-port-availability-using-java
     * Socket docs: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/net/Socket.html
     * Modified wrong code on From stack overflow to match what it really needs to do.
     * @param ipAddress requires InnetAddress object
     * @param port  Self-explanatory requires int
     */
    private static boolean portOpen(InetAddress ipAddress, int port) {
        try {
            Socket sock = new Socket(ipAddress, port);
            System.out.println("TCP port: " + port + " alive and available for fun.");
            sock.close();
            return true;
        } catch (IOException e) {

            System.out.println("PortNotAvailable");
        }
        return false;
    }

    public static void cycleThroughCommonPorts(InetAddress ipAddress){
        PortList.readCommonPorts();

        for(Map.Entry<Integer, String> portEntry : PortList.commonPorts.entrySet()){
            Integer port = portEntry.getKey();
            portOpen(ipAddress, port);
        }

    }




}
