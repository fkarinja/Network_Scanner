package Application.UserInterface;

import Application.InputParser.UserInputParse;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.LineNumberReader;

public class ScanPanel extends JPanel {

    private JTextField ipAddressTxt;
    private JLabel guideLbl;
    private JLabel guideLbl2;
    private JButton scanButton;
    private ScanPanelListener scanPanelListener;

    public ScanPanel(){


        Dimension dimension = getPreferredSize();
        dimension.height = 140;
        dimension.width = 380;
        setPreferredSize(dimension);

        //Set everything here
        setBorders();
        initialisePanels();
        setComponentLayout();
        activateSearchButton();
    }

    private void setBorders(){
        Border border = BorderFactory.createEtchedBorder();
        setBorder(border);
    }

    private void initialisePanels(){
        ipAddressTxt = new JTextField(30);
        guideLbl = new JLabel("Please enter FQDN, IP address or IP range");
        guideLbl2 = new JLabel("in format: 192.168.1.1-255");
        scanButton = new JButton("Scan");



    }

    private void setComponentLayout(){
        setLayout(null);

        Dimension dimLbl = guideLbl.getPreferredSize();
        guideLbl.setBounds(20, 10, dimLbl.width, dimLbl.height);
        add(guideLbl);

        Dimension dimLbl2 = guideLbl.getPreferredSize();
        guideLbl2.setBounds(20, 30, dimLbl2.width, dimLbl2.height);
        add(guideLbl2);

        Dimension dimTxt = ipAddressTxt.getPreferredSize();
        ipAddressTxt.setBounds(20, 60, dimTxt.width, dimTxt.height);
        add(ipAddressTxt);

        scanButton.setBounds(130, 90, 100, 30);
        add(scanButton);

    }

    private void activateSearchButton(){
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchInput = ipAddressTxt.getText();
                ScanPanelEvent scanPanelEvent = new ScanPanelEvent(ScanPanel.this, searchInput);

                if(scanPanelListener != null){
                    scanPanelListener.ScanPanelEventOccurred(scanPanelEvent);
                    ipAddressTxt.setText("");
                }


            }
        });
    }

    public void setScanPanelListener(ScanPanelListener scanPanelListener){this.scanPanelListener = scanPanelListener;}


}
