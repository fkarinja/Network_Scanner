package Application.FileWorks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Messenger {

    private static String fileLocation = "src/Application/Log/Message.txt";
    private static File file = new File(fileLocation);

    public static void newMessage(String message){
        try {
            FileWriter fileWriter = new FileWriter(fileLocation);
            fileWriter.write(message);
            fileWriter.close();
        } catch (IOException e) {
            Messenger.newMessage("Log file not found!!!");
        }
    }


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
