package Application.UserInterface;

import java.util.EventListener;

public interface ScanPanelListener extends EventListener {
    /**
     * On some event this interface creates new Event
     * @param scanPanelEvent
     */
    void ScanPanelEventOccurred(ScanPanelEvent scanPanelEvent);
}
