package AppModel;

import AppService.Logger;
import AppService.SettingManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.SECONDS;

abstract class Table {

    int Id;
    int TableNum;
    String Type;
    LocalDateTime TimeCreated;
    LocalDateTime TimeStarted;
    public LocalDateTime TimeFinished;
    int TotalHeads;
    int KidHeads;
    int AdultHeads;

    //region getter-setter

    public int getId() {
        return Id;
    }

    public int getTableNum() {
        return TableNum;
    }

    public void setTableNum(int tableNum) {
        TableNum = tableNum;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public LocalDateTime getTimeStarted() {
        return TimeStarted;
    }

    public int getTotalHeads() {
        return TotalHeads;
    }

    public void setTotalHeads(int totalHeads) {
        if (this instanceof TableBooking)
            TotalHeads = totalHeads;
        else
            TotalHeads = KidHeads + AdultHeads;
    }

    public int getKidHeads() {
        return KidHeads;
    }

    public void setKidHeads(int kidHeads) {
        KidHeads = kidHeads;
    }

    public int getAdultHeads() {
        return AdultHeads;
    }

    public void setAdultHeads(int adultHeads) {
        AdultHeads = adultHeads;
    }

    //endregion

    public void doFinished() {
        TimeFinished = LocalDateTime.now();
    }

    public long calExcessSeconds() {
        return TimeStarted.until(TimeFinished.minus(SettingManager.i().getTimeLimit(), SECONDS), SECONDS);
    }

    public double calExcessFine() {
        if (calExcessSeconds() > 0)
            return Math.ceil((double) calExcessSeconds() / SettingManager.i().getTimeExcess()) * SettingManager.i().getExcessFine();
        else
            return 0;
    }

    public void toLog() {
        String log;
        if (SettingManager.i().isSeparateKA())
            log = String.format("Customer %d (Created on %s)\n" +
                            "Table number: %d\n" +
                            "Type: %s\n" +
                            "Time started: %s\n" +
                            "Time finished: %s\n" +
                            "Heads: %d (Kids: %d, Adult: %d)",
                    Id,
                    TimeCreated.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")),
                    TableNum,
                    Type,
                    TimeStarted.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    TimeFinished.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    TotalHeads,
                    KidHeads,
                    AdultHeads);
        else
            log = String.format("Customer %d (Created on %s)\n" +
                            "Table number: %d\n" +
                            "Type: %s\n" +
                            "Time started: %s\n" +
                            "Time finished: %s\n" +
                            "Heads: %d",
                    Id,
                    TimeCreated.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")),
                    TableNum,
                    Type,
                    TimeStarted.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    TimeFinished.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    TotalHeads);
        Logger.i().addLog(log);
    }
}
