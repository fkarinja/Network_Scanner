package Application.FileWorks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class designed to transfer backend messages to the UI
 */

public class Messenger {

    private static String fileLocation = "src/Application/Log/Message.txt";
    private static File file = new File(fileLocation);

    /**
     * Method which writes a backend message to a TXT log file
     * @param message   String containing the message
     */


    public static void newMessage(String message){
        try {
            FileWriter fileWriter = new FileWriter(fileLocation);
            fileWriter.write(message);
            fileWriter.close();
        } catch (IOException e) {
            Messenger.newMessage("Log file not found!!!");
        }
    }

    /**
     * Reads a message from the TXT file and returns it to caller
     * @return returns message from TXT
     */


    public static String getMessage(){
        Scanner messageRead = null;

        try {
            messageRead = new Scanner(file);

            while (messageRead.hasNext()){
                return messageRead.nextLine();
            }

        } catch (FileNotFoundException e) {
           return "Log file not found!";
        }
        return "";
    }
}
