package AppModel;

import AppService.Logger;
import AppService.SettingManager;
import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static AppService.TimeManager.secondToStr;
import static AppService.TimeManager.sepTime;
import static AppUtil.Converter.byteName;
import static AppUtil.Converter.strFromByte;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TableActive extends Table {


    LocalDateTime TimeFinished;
    boolean Finished = false;
    double TotalPrice;

    public TableActive() {}

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

    TableActive(int id, int tableNum, byte[] type, LocalDateTime timeCreated, LocalDateTime timeStarted, int kidsHeads, int adultHeads, LocalDateTime timeFinished, boolean finished, double totalPrice) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCreated = timeCreated;
        TimeStarted = timeStarted;
        TimeFinished = timeFinished;
        Finished = finished;
        TotalPrice = totalPrice;
    }

    public LocalDateTime getTimeFinished() {
        return TimeFinished;
    }

    public void setFinished() {
        if (!Finished)
            TimeFinished = LocalDateTime.now();
        Finished = true;
    }

    public boolean isFinished() {
        return Finished;
    }

    public long calExcessSeconds() {
        return TimeStarted.until(TimeFinished.minus(SettingManager.i().getTimeLimit(), SECONDS), SECONDS);
    }

    public void updateTime() {
        if (!Finished) {
            long time;
            if (SettingManager.i().isLimitTime())
                time = 0 - TimeStarted.until(LocalDateTime.now().minus(SettingManager.i().getTimeLimit(), SECONDS), SECONDS);
            else
                time = TimeStarted.until(LocalDateTime.now(), SECONDS);

            long[] times = sepTime(Math.abs(time));
            String clock = String.format("%02d: %02d: %02d", times[0], times[1], times[2]);

            if (SettingManager.i().isLimitTime()) {
                if (time > 0)
                    TimeLab.setText(clock + "r");
                else
                    TimeLab.setText(clock + "ec");
            }
            else
                TimeLab.setText(clock + "e");
        }
    }

    public String getTxtTime(char mode) {
        // o = over time
        // t = total time (also everything else)
        long time;
        if (!Finished) {
            if (mode == 'o')
                time = 0 - TimeStarted.until(LocalDateTime.now().minus(SettingManager.i().getTimeLimit(), SECONDS), SECONDS);
            else
                time = TimeStarted.until(LocalDateTime.now(), SECONDS);

        }
        else {
            if (mode == 'o')
                time = 0 - TimeStarted.until(TimeFinished.minus(SettingManager.i().getTimeLimit(), SECONDS), SECONDS);
            else
                time = TimeStarted.until(TimeFinished, SECONDS);

        }

        if (mode == 'o' && time > 0)
            return "00: 00: 00";

        long[] times = sepTime(Math.abs(time));
        return String.format("%02d: %02d: %02d", times[0], times[1], times[2]);

    }

    public double calExcessFine() {
        if (calExcessSeconds() > 0)
            return (double) (calExcessSeconds() / SettingManager.i().getTimePerExcess()) * SettingManager.i().getExcessFine();
        else
            return 0;
    }

    public double calAdultsPrice() {
        return AdultHeads * SettingManager.i().getPriceAdult(Type);
    }

    public double calKidsPrice() {
        return KidHeads * SettingManager.i().getPriceKids(Type);
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public void toLog() {
        String log;
        log = String.format("Customer %d (Created on %s)%n" +
                        "Table number: %d%n" +
                        "Type: %s%n" +
                        "Time started: %s%n" +
                        "Time finished: %s%n" +
                        "Kid Heads: %d%n" +
                        "Adult Heads: %d%n" +
                        "Total Price: %f%n",
                Id,
                TimeCreated.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")),
                TableNum,
                strFromByte(Type),
                TimeStarted.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                TimeFinished.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                KidHeads,
                AdultHeads,
                TotalPrice);
        Logger.i().addLog(log);
    }
}
