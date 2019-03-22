package AppService;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger ourInstance = new Logger();

    public static Logger i() {
        return ourInstance;
    }

    FileWriter writer;

    private Logger() {
        try {
            System.out.print("Hi");
            writer = new FileWriter(SaverAndLoader.getFile("log.txt"), true);

            writer.append("...............................................\n\n\n" +
                    "-----------------------------------------------\n" +
                    "***********************************************\n" +
                    "Session " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")) +
                    "\n***********************************************\n" +
                    "-----------------------------------------------\n");
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addLog(String text) {
        try {
            writer.append(text + "\n-----------------------------------------------\n");
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
