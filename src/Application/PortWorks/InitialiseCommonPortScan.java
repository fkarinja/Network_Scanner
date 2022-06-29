package Application.PortWorks;

import Application.NetworkDevice.Device;
import java.util.Map;

public class InitialiseCommonPortScan {

    public static void cycleThroughCommonPorts(Device device){
        PortList.readCommonPorts();

        for(Map.Entry<Integer, String> portEntry : PortList.commonPorts.entrySet()){
            Integer port = portEntry.getKey();
            PortScan.portScan(port, device);
        }

    }

}
