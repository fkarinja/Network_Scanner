package Application.UserInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.PrintWriter;

public class ResultsPanel extends JPanel {

    private JScrollPane liveIP;
    private JScrollPane openPorts;
    private JLabel liveIPLbl;
    private JLabel openPortslBl;
    private JList<String> liveIPList;
    private JList<String> openPortsList;
    private JButton saveResults;
    private JButton loadResults;
    private JButton exportResults;


    public ResultsPanel(){


        Dimension dimension = getPreferredSize();
        dimension.height = 450;
        dimension.width = 380;
        setPreferredSize(dimension);


        //Set everything here
        setBorders();
        initialisePanels();
        setComponentLayout();
    }

    private void setBorders(){
        Border border = BorderFactory.createEtchedBorder();
        setBorder(border);
    }

    private void initialisePanels(){
        liveIPLbl = new JLabel("Active IP addresses:");
        liveIPList = new JList<>();
        liveIP = new JScrollPane(liveIPList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        openPortslBl = new JLabel("Open ports:");
        openPortsList = new JList<>();
        openPorts =  new JScrollPane(openPortsList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        saveResults = new JButton("Save results");
        loadResults = new JButton("Load results");
        exportResults = new JButton("Export results");
    }

    private void setComponentLayout(){
        setLayout(null);

        Dimension IPDim = liveIPLbl.getPreferredSize();
        liveIPLbl.setBounds(20, 10, IPDim.width, IPDim.height);
        add(liveIPLbl);

        liveIP.setBounds(20,30, 350, 200);
        add(liveIP);

        Dimension openPortDim = openPortslBl.getPreferredSize();
        openPortslBl.setBounds(20, 240, openPortDim.width, openPortDim.height);
        add(openPortslBl);

        openPorts.setBounds(20, 260, 180, 110);
        add(openPorts);

        saveResults.setBounds(210, 260, 150, 30);
        add(saveResults);

        loadResults.setBounds(210, 300, 150, 30);
        add(loadResults);

        exportResults.setBounds(210, 340, 150, 30);
        add(exportResults);





    }

}
