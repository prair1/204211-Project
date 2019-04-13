package AppModel;

import java.time.LocalDateTime;

public class TableActive extends Table {

    public TableActive(int id, int tableNum, String type, int kidsHeads, int adultHeads) {
        Id = id;
        TableNum = tableNum;
        Type = type;
        KidHeads = kidsHeads;
        AdultHeads = adultHeads;
        TimeCreated = LocalDateTime.now();
        TimeStarted = LocalDateTime.now();
    }
}
