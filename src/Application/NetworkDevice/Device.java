package Application.NetworkDevice;

import java.net.InetAddress;
import java.util.ArrayList;

public class Device {

    private InetAddress ipAddress;
    private ArrayList<Integer> openPorts = new ArrayList<>();


    public Device(InetAddress address){
        this.ipAddress = address;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public ArrayList<Integer> getOpenPorts() {
        return openPorts;
    }

    public void addOpenPorts(int openPort) {
        this.openPorts.add(openPort);
    }

    @Override
    public String toString() {
        return "Device{" +
                "ipAddress=" + ipAddress +
                ", openPorts=" + openPorts +
                '}';
    }
}
