package AppModel;

import AppService.SettingManager;
import com.google.gson.annotations.Expose;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static AppService.TimeManager.sepTime;
import static AppUtil.Converter.byteName;
import static AppUtil.Converter.strFromByte;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TableBooking extends Table {

    LocalDateTime TimeCheckin;
    byte[] customerName;

    public TableBooking() {}

    public TableBooking(int id, int tableNum, String course, int kidsNumber, int adultNumber, LocalDateTime timeCheckin, String customerName) {
        Id = id;
        TableNum = tableNum;
        Course = byteName(course);
        KidNumber = kidsNumber;
        AdultNumber = adultNumber;
        TimeCheckin = timeCheckin;
        TimeCreated = LocalDateTime.now();
        this.customerName = byteName(customerName);
    }

    public String getCustomerName() {
        return strFromByte(customerName);
    }

    public LocalDateTime getTimeCheckin() {
        return TimeCheckin;
    }

    public TableActive toActive() {
        return new TableActive(Id, TableNum, Course, KidNumber, AdultNumber);
    }

    public void updateTime() {
        long time = LocalDateTime.now().until(TimeCheckin, SECONDS);

        long[] times = sepTime(Math.abs(time));
        String clock = String.format("%02d: %02d: %02d", times[0], times[1], times[2]);
        if (time > 0)
            TimeLab.setText(clock + "r");
        else
            TimeLab.setText(clock + "ec");
    }

    public String getCheckinDate() {
        return String.format("%d/%d/%d", TimeCheckin.getDayOfMonth(), TimeCheckin.getMonthValue(), TimeCheckin.getYear());
    }

    public String getCheckinTime() {
        return String.format("%02d:%02d", TimeCheckin.getHour(), TimeCheckin.getMinute());
    }
}
