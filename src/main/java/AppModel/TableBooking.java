package AppModel;

import java.time.LocalDateTime;

public class TableBooking extends Table {
    private LocalDateTime TimeCheckin;

    public TableBooking(int id, int tableNum, String type, int totalHeads, LocalDateTime timeCheckin) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TotalHeads = totalHeads;
        TimeCheckin = timeCheckin;
        TimeCreated = LocalDateTime.now();
    }

    public LocalDateTime getTimeCheckin() {
        return TimeCheckin;
    }

    public TableActive startTable(int totalHeads) {
        return new TableActive(Id, TableNum, Type, totalHeads);
    }

    public TableActive startTable(int kidsHeads, int adultHeads) {
        return new TableActive(Id, TableNum, Type, kidsHeads, adultHeads);
    }
}
