package AppModel;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class TableBooking extends Table {
    private LocalDateTime TimeCheckin;
    private byte[] customerName;
    private int TotalHeads;

    public TableBooking(int id, int tableNum, String type, int kidsHeads, int adultHeads, LocalDateTime timeCheckin, String customerName) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCheckin = timeCheckin;
        TimeCreated = LocalDateTime.now();
        this.customerName = customerName.getBytes();
    }

    public int getTotalHeads() {
        return TotalHeads;
    }

    public String getCustomerName() {
        return new String(customerName, StandardCharsets.UTF_8);
    }

    public LocalDateTime getTimeCheckin() {
        return TimeCheckin;
    }


    public TableActive startTable() {
        return new TableActive(Id, TableNum, Type, KidHeads, AdultHeads);
    }
}
