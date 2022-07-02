package Application.TraceRoute;


import Application.NetworkDevice.Device;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class TraceRoute {

    private final String os = System.getProperty("os.name").toLowerCase();

    public static void traceRoute(Device device) {

        InetAddress address = device.getIpAddress();
        String route = "";
        try {
            Process traceRt;
            traceRt = Runtime.getRuntime().exec("tracert -w 100 -d " + address.getHostAddress());


            // read the output from the command
            Scanner input = new Scanner(traceRt.getInputStream());
            while (input.hasNext()) {
                route = route + input.nextLine() + "\n";

            }

//            // read any errors from the attempted command
//            String errors = convertStreamToString(traceRt.getErrorStream());
//            if(errors != "") LOGGER.error(errors);


        } catch (IOException e) {
            System.out.println(e);
        }

        device.setTraceRoute(route);
    }



}
