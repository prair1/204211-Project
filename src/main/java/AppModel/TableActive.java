package AppModel;

import java.time.LocalDateTime;

public class TableActive extends Table {

    TableActive(int id, int tableNum, String type, int totalHeads) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TotalHeads = totalHeads;
        TimeCreated = LocalDateTime.now();
        TimeStarted = LocalDateTime.now();
    }

    public TableActive(int id, int tableNum, String type, int kidsHeads, int adultHeads) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        TotalHeads = kidsHeads + adultHeads;
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCreated = LocalDateTime.now();
        TimeStarted = LocalDateTime.now();
    }
}
