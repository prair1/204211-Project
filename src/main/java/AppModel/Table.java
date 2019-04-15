package AppModel;

import com.google.gson.annotations.Expose;
import javafx.scene.control.Label;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static AppUtil.Converter.byteName;
import static AppUtil.Converter.strFromByte;

public abstract class Table {

    int Id;
    int TableNum;
    byte[] Type;
    LocalDateTime TimeCreated;
    LocalDateTime TimeStarted;
    int KidHeads;
    int AdultHeads;
    transient Label TimeLab;

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
        return strFromByte(Type);
    }

    public void setType(String type) {
        Type = byteName(type);
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

    public void setTimeLab(Label timeLab) {
        TimeLab = timeLab;
        updateTime();
    }

    public Label getTimeLab() {
        return TimeLab;
    }

    //endregion

    abstract void updateTime();
}
