package AppModel;

import java.time.LocalDateTime;

public class TableBooking extends Table {
    private LocalDateTime TimeCheckin;
    private byte[] customerName;
    private int TotalHeads;

    public TableBooking(int id, int tableNum, String type, int totalHeads, LocalDateTime timeCheckin, String customerName) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TotalHeads = totalHeads;
        TimeCheckin = timeCheckin;
        TimeCreated = LocalDateTime.now();
        this.customerName = customerName.getBytes();
    }

    public int getTotalHeads() {
        return TotalHeads;
    }

    public LocalDateTime getTimeCheckin() {
        return TimeCheckin;
    }


    public TableActive startTable(int kidsHeads, int adultHeads) {
        return new TableActive(Id, TableNum, Type, kidsHeads, adultHeads);
    }
}
