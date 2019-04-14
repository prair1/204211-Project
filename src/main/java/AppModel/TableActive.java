package AppModel;

import AppService.Logger;
import AppService.SettingManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static AppUtil.Converter.byteName;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TableActive extends Table {

    private LocalDateTime TimeFinished;

    TableActive(int id, int tableNum, byte[] type, int kidsHeads, int adultHeads) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCreated = LocalDateTime.now();
        TimeStarted = LocalDateTime.now();
    }

    public TableActive(int id, int tableNum, String type, int kidsHeads, int adultHeads) {
        Id = id;
        TableNum = tableNum;
        Type = byteName(type);
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCreated = LocalDateTime.now();
        TimeStarted = LocalDateTime.now();
    }

    public LocalDateTime getTimeFinished() {
        return TimeFinished;
    }

    public void setFinished() {
        TimeFinished = LocalDateTime.now();
    }


    public long calExcessSeconds() {
        return TimeStarted.until(TimeFinished.minus(SettingManager.i().getTimeLimit(), SECONDS), SECONDS);
    }

    public double calExcessFine() {
        if (calExcessSeconds() > 0)
            return Math.ceil((double) calExcessSeconds() / SettingManager.i().getTimePerExcess()) * SettingManager.i().getExcessFine();
        else
            return 0;
    }

    public void toLog() {
        String log;
        log = String.format("Customer %d (Created on %s)%n" +
                        "Table number: %d%n" +
                        "Type: %s%n" +
                        "Time started: %s%n" +
                        "Time finished: %s%n" +
                        "Kid Heads: %d%n" +
                        "Adult Heads: %d%n",
                Id,
                TimeCreated.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")),
                TableNum,
                Type,
                TimeStarted.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                TimeFinished.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                KidHeads,
                AdultHeads);
        Logger.i().addLog(log);
    }
}
