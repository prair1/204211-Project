package AppModel;

import java.time.LocalDateTime;

abstract class Table {

    int Id;
    int TableNum ;
    String Type;
    LocalDateTime TimeCreated;
    LocalDateTime TimeStarted;
    int TotalHead;
    int KidHead;
    int AdultHead;

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

    public int getTotalHead() {
        return TotalHead;
    }

    public void setTotalHead(int totalHead) {
        if (this instanceof TableBooking)
            TotalHead = totalHead;
        else
            TotalHead = KidHead + AdultHead;
    }

    public int getKidHead() {
        return KidHead;
    }

    public void setKidHead(int kidHead) {
        KidHead = kidHead;
    }

    public int getAdultHead() {
        return AdultHead;
    }

    public void setAdultHead(int adultHead) {
        AdultHead = adultHead;
    }

    //endregion
}
