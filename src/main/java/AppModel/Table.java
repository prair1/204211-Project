package AppModel;

import java.time.LocalDateTime;

abstract class Table {

    int Id;
    int TableNum;
    String Type;
    LocalDateTime TimeCreated;
    LocalDateTime TimeStarted;
    int KidHeads;
    int AdultHeads;

    //region getter-setter
    public int getId() {
        return Id;
    }

    public int getTableNum() {
        return TableNum;
    }

    public void setTableNum(int tableNum) {
        TableNum = tableNum;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public LocalDateTime getTimeStarted() {
        return TimeStarted;
    }

    public int getKidHeads() {
        return KidHeads;
    }

    public void setKidHeads(int kidHeads) {
        KidHeads = kidHeads;
    }

    public int getAdultHeads() {
        return AdultHeads;
    }

    public void setAdultHeads(int adultHeads) {
        AdultHeads = adultHeads;
    }
    //endregion
}
