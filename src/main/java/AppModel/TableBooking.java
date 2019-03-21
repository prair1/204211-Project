package AppModel;

import java.time.LocalDateTime;

public class TableBooking extends Table {
    private LocalDateTime TimeCheckin;

    public LocalDateTime getTimeCheckin() {
        return TimeCheckin;
    }

    public TableBooking(int id, int tableNum, String type, int totalHead, LocalDateTime timeCheckin) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TotalHead = totalHead;
        TimeCheckin = timeCheckin;
        TimeCreated = LocalDateTime.now();
    }

    public TableActive startTable(int kidsHead, int adultHead) {
        return new TableActive(Id, TableNum, Type, TimeCreated, LocalDateTime.now(), TotalHead, kidsHead, adultHead);
    }
}
