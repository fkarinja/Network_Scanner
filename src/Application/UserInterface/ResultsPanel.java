package Application.UserInterface;

import Application.FileWorks.DeviceExportToTXT;
import Application.InputParser.UserInputParse;
import Application.FileWorks.Messenger;
import Application.NetworkDevice.Device;
import Application.FileWorks.DeviceObjectToBIN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResultsPanel extends JPanel {

    private JScrollPane liveIP;
    private JLabel liveIPLbl;
    private JTextArea liveIPTextArea;
    private JButton saveResults;
    private JButton loadResults;
    private JButton exportResults;
    private JTextArea message;

    /**
     * Panel object definition
     */

    public ResultsPanel(){


        Dimension dimension = getPreferredSize();
        dimension.height = 450;
        dimension.width = 380;
        setPreferredSize(dimension);


        //Set everything here
        setBorders();
        initialiseComponents();
        setComponentLayout();
        activateButtons();
    }

    /**
     * Border creation
     */

    private void setBorders(){
        Border border = BorderFactory.createEtchedBorder();
        setBorder(border);
    }

    /**
     * Component Initialisation
     */

    private void initialiseComponents(){
        liveIPLbl = new JLabel("Active IP addresses:");
        liveIPTextArea = new JTextArea();
        liveIPTextArea.setEditable(false);
        liveIP = new JScrollPane(liveIPTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        saveResults = new JButton("Save results");
        saveResults.setEnabled(false);
        loadResults = new JButton("Load results");

        exportResults = new JButton("Export results");
        exportResults.setEnabled(false);
        message = new JTextArea("Message: ");
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        message.setFocusable(false);

    }

    /**
     * Component layout and adding to Panel object
     */

    private void setComponentLayout(){
        setLayout(null);


        Dimension IPDim = liveIPLbl.getPreferredSize();
        liveIPLbl.setBounds(20, 10, IPDim.width, IPDim.height);
        add(liveIPLbl);

        liveIP.setBounds(20,30, 350, 200);
        add(liveIP);

        saveResults.setBounds(20, 240, 150, 30);
        add(saveResults);

        loadResults.setBounds(180, 240, 150, 30);
        add(loadResults);

        exportResults.setBounds(20, 280, 150, 30);
        add(exportResults);

        message.setBounds(20, 320, 350, 40);
        add(message);
    }

    /**
     * Button functionality and "backend interaction"
     */

    private void activateButtons(){

        /**
         * Initialises saving UserInputParse.foundDevices objects to file
         */
        saveResults.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                //fileChooser
                JFileChooser binSave = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                binSave.addChoosableFileFilter(new FileNameExtensionFilter("Bin file", "bin"));
                binSave.removeChoosableFileFilter(binSave.getAcceptAllFileFilter());

                int bs = binSave.showSaveDialog(null);

                if(bs == JFileChooser.APPROVE_OPTION){
                    String filePath = binSave.getSelectedFile().getAbsolutePath() + ".bin";
                    DeviceObjectToBIN.deviceToFile(filePath);
                }
                message.setText(Messenger.getMessage());

            }
        });

        /**
         * Initialises loading Device object from BIN file to UserInputParse.foundDevices
         */

        loadResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInputParse.foundDevices.clear();

                //fileChooser
                JFileChooser binLoad = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                binLoad.addChoosableFileFilter(new FileNameExtensionFilter("Bin file", "bin"));
                binLoad.removeChoosableFileFilter(binLoad.getAcceptAllFileFilter());

                int bl = binLoad.showSaveDialog(null);

                if(bl == JFileChooser.APPROVE_OPTION){
                    String filePath = binLoad.getSelectedFile().getAbsolutePath();
                    DeviceObjectToBIN.deviceFromFile(filePath);

                    loadResults();
                    exportResults.setEnabled(true);
                } else {
                    Messenger.newMessage("[!] User canceled operation!");
                }


                message.setText(Messenger.getMessage());

            }
        });

        /**
         * Initialises exporting device objects from UserInputParse.foundDevices to a TXT file, via device.toString
         */

        exportResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser txtExport = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                txtExport.addChoosableFileFilter(new FileNameExtensionFilter("TXT file", "txt"));
                txtExport.removeChoosableFileFilter(txtExport.getAcceptAllFileFilter());

                int bl = txtExport.showSaveDialog(null);

                if(bl == JFileChooser.APPROVE_OPTION){
                    String filePath = txtExport.getSelectedFile().getAbsolutePath() + ".txt";
                    DeviceExportToTXT.exportResultsToTxt(filePath);
                } else {
                    Messenger.newMessage("[!] User canceled operation!");
                }

                message.setText(Messenger.getMessage());
            }
        });


    }

    /**
     * Adds new device String output to textArea
     * @param deviceString
     */

    public void appendLiveIPTextArea(String deviceString){
        liveIPTextArea.append(deviceString);
        liveIPTextArea.append("\n");
    }

    /**
     * Resets textArea
     */

    public void resetLiveIPTextArea(){
        liveIPTextArea.setText("");
    }

    /**
     * Changes the message in Message textBox
     * @param message
     */

    public void setMessage(String message) {
        this.message.setText("Message: " + message);
    }

    /**
     * Changes button availability
     */

    public void enableSaveResults(){
        this.saveResults.setEnabled(true);
    }


    /**
     * Changes button availability
     */

    public void enableExportResults(){
        this.exportResults.setEnabled(true);
    }


    /**
     * Loads devices from UserInputParse.foundDevices to textArea
     */

    private void loadResults(){
        liveIPTextArea.setText("");

        for(Device device : UserInputParse.foundDevices){
            liveIPTextArea.append(device.toString());
            liveIPTextArea.append("\n");
        }

    }
}
