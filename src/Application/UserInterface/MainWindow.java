package Application.UserInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    ScanPanel scanPanel;
    ResultsPanel resultsPanel;

    public MainWindow(){
        super("Common ports scanner");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,580);

        //initialise
        initialiseComponents();
        panelLayout();
        activateMainWindow();
    }

    private void initialiseComponents(){
        //Initialise frame objects here
        scanPanel = new ScanPanel();
        resultsPanel = new ResultsPanel();
    }

    private void panelLayout(){
        setLayout(new BorderLayout());
        //add them here
        add(scanPanel, BorderLayout.NORTH);
        add(resultsPanel);
    }

    void activateMainWindow(){
        //Listener methodology and connect to "Backend"
    }


}
