package Application.UserInterface;

import Application.InputParser.UserInputParse;
import Application.FileWorks.Messenger;
import Application.NetworkDevice.Device;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MainWindow extends JFrame {

    private ScanPanel scanPanel;
    private ResultsPanel resultsPanel;

    /**
     * MainWindow   Object
     */

    public MainWindow(){
        super("Common ports scanner");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,550);

        //initialise
        initialiseComponents();
        panelLayout();
        activateMainWindow();
    }

    /**
     * JPanel initialization
     */

    private void initialiseComponents(){
        //Initialise frame objects here
        scanPanel = new ScanPanel();
        resultsPanel = new ResultsPanel();
    }

    /**
     * Layout
     */

    private void panelLayout(){
        setLayout(new BorderLayout());
        //add them here
        add(scanPanel, BorderLayout.NORTH);
        add(resultsPanel);
    }

    /**
     * Main window functionality an interaction with "backend"
     */

    void activateMainWindow(){
        //Listener methodology and connect to "Backend"

        scanPanel.setScanPanelListener(new ScanPanelListener() {
            @Override
            public void ScanPanelEventOccurred(ScanPanelEvent scanPanelEvent) {

                String searchIP = scanPanelEvent.getIpAddressSearch();
                UserInputParse.initialParser(searchIP);
                resultsPanel.resetLiveIPTextArea();
                for(Device device : UserInputParse.foundDevices){
                    resultsPanel.appendLiveIPTextArea(device.toString());
                }

                Scanner message = null;

                resultsPanel.setMessage(Messenger.getMessage());

                if(!UserInputParse.foundDevices.isEmpty()){
                    resultsPanel.enableSaveResults();
                    resultsPanel.enableExportResults();
                }

            }
        });

    }

}
