package Application.UserInterface;

import java.util.EventListener;

public interface ScanPanelListener extends EventListener {
    void ScanPanelEventOccurred(ScanPanelEvent scanPanelEvent);
}
