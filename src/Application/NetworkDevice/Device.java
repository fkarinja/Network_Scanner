package Application.NetworkDevice;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;

public class Device implements Serializable {

    private InetAddress ipAddress;
    private ArrayList<Integer> openPorts = new ArrayList<>();
    private String hostName;


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

    public String getCanonicalName() {
        return hostName;
    }

    public void setCanonicalName(String canonicalName) {
        hostName = canonicalName;
    }

    @Override
    public String toString() {
        return "Device{" +
                "ipAddress=" + ipAddress +
                ", hostName='" + hostName +
                ", openPorts=" + openPorts +'\'' +
                '}';
    }
}
