package AppModel;

import java.time.LocalDateTime;

public class TableActive extends Table {

    TableActive(int id, int tableNum, String type, LocalDateTime timeCreated,
                 LocalDateTime timeStarted, int totalHead, int kidHead, int adultHead) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TimeCreated = timeCreated;
        TimeStarted = timeStarted;
        TotalHead = totalHead;
        KidHead = kidHead;
        AdultHead = adultHead;
    }

    public TableActive(int id, int tableNum, String type, int kidsHead, int adultHead) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TotalHead = kidsHead + adultHead;
        KidHead = kidsHead;
        AdultHead = adultHead;
        TimeCreated = LocalDateTime.now();
        TimeStarted = TimeCreated;
    }
}
