package Application.UserInterface;

import java.util.EventObject;

public class ScanPanelEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    private String ipAddressSearch;


    public ScanPanelEvent(Object source) {
        super(source);
    }

    public ScanPanelEvent(Object source, String ipAddressSearch) {
        super(source);
        this.ipAddressSearch = ipAddressSearch;
    }

    public String getIpAddressSearch() {
        return ipAddressSearch;
    }

    @Override
    public String toString() {
        return "ScanPanelEvent{" +
                "ipAddressSearch='" + ipAddressSearch + '\'' +
                '}';
    }
}
