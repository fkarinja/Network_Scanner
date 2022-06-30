package Application.PortWorks;

import Application.NetworkDevice.Device;
import java.util.Map;

public class InitialiseCommonPortScan {

    /**
     * Initialises reading ports from txt file into TreeMap, and runs PortScan for each oo the ports for device
     * @param device    Device object for which to run a port scan for
     */

    public static void cycleThroughCommonPorts(Device device){
        PortList.readCommonPorts();

        for(Map.Entry<Integer, String> portEntry : PortList.commonPorts.entrySet()){
            Integer port = portEntry.getKey();
            PortScan.portScan(port, device);
        }

    }

}
