package Application;

import Application.UserInterface.MainWindow;
import javax.swing.*;


/**
 * @author Created by Frane Karinja
 * @date June 2022
 */

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();

            }
        });
    }
}
