package Application.PortWorks;

import Application.NetworkDevice.Device;
import java.util.Map;

public class InitialiseCommonPortScan {

    /**
     * Ostavio sam ovo u zasebnoj klasi da mogu negdje u budućnosti klasu PortScan extendati runnable
     * @param device
     */

    public static void cycleThroughCommonPorts(Device device){
        PortList.readCommonPorts();

        for(Map.Entry<Integer, String> portEntry : PortList.commonPorts.entrySet()){
            Integer port = portEntry.getKey();
            PortScan.portScan(port, device);
        }

    }

}
