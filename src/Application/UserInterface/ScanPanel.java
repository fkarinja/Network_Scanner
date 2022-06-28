package Application.UserInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.LineNumberReader;

public class ScanPanel extends JPanel {

    private JTextField ipAddressTxt;
    private JLabel guideLbl;
    private JButton scanButton;

    public ScanPanel(){


        Dimension dimension = getPreferredSize();
        dimension.height = 140;
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
        ipAddressTxt = new JTextField(30);
        guideLbl = new JLabel("Please enter IP address or range in format: 192.168.1.1-255");
        scanButton = new JButton("Scan");



    }

    private void setComponentLayout(){
        setLayout(null);

        Dimension dimLbl = guideLbl.getPreferredSize();
        guideLbl.setBounds(20, 30, dimLbl.width, dimLbl.height);
        add(guideLbl);

        Dimension dimTxt = ipAddressTxt.getPreferredSize();
        ipAddressTxt.setBounds(20, 60, dimTxt.width, dimTxt.height);
        add(ipAddressTxt);

        scanButton.setBounds(130, 90, 100, 30);
        add(scanButton);

    }

}
