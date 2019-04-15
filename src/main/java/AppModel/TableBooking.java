package AppModel;

import com.google.gson.annotations.Expose;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static AppUtil.Converter.byteName;
import static AppUtil.Converter.strFromByte;

public class TableBooking extends Table {

    LocalDateTime TimeCheckin;
    byte[] customerName;

    public TableBooking() {}

    public TableBooking(int id, int tableNum, String type, int kidsHeads, int adultHeads, LocalDateTime timeCheckin, String customerName) {
        Id = id;
        TableNum = tableNum;
        Type = byteName(type);
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCheckin = timeCheckin;
        TimeCreated = LocalDateTime.now();
        this.customerName = byteName(customerName);
    }

    public TableBooking(int id, int tableNum, byte[] type, LocalDateTime timeCreated, int kidsHeads, int adultHeads, LocalDateTime timeCheckin, byte[] customerName) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCheckin = timeCheckin;
        TimeCreated = timeCreated;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return strFromByte(customerName);
    }

    public LocalDateTime getTimeCheckin() {
        return TimeCheckin;
    }

    public TableActive startTable() {
        return new TableActive(Id, TableNum, Type, KidHeads, AdultHeads);
    }

    public void updateTime() {

    }
}
