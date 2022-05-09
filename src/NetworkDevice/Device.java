package NetworkDevice;

import java.net.InetAddress;
import java.util.ArrayList;

public class Device {
    private int id;
    private String address = new String();
    //Ako uspijem upogoniti service detector, onda ovo ide u TreeMap
    private static ArrayList<String> openPorts = new ArrayList<String>();
    private int cntID = 10;

    public Device(InetAddress address){
        this.address = address.toString().replace("/", "");
        this.id = cntID;
        cntID++;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getOpenPorts() {
        return openPorts;
    }

    public void addOpenPorts(String openPort) {
        this.getOpenPorts().add(openPort);
    }
}
