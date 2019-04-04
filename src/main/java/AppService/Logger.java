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
            writer = new FileWriter(SaverAndLoader.getFile("log " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy @ HH.mm.ss")) + ".txt"), true);

            writer.append(String.format("Session %s%n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"))));
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addLog(String text) {
        try {
            writer.append(String.format("-----------------------------------------------%n%s%n-----------------------------------------------%n", text));
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
