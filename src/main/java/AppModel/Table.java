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
    byte[] Course;
    LocalDateTime TimeCreated;
    LocalDateTime TimeStarted;
    int KidNumber;
    int AdultNumber;
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

    public String getCourse() {
        return strFromByte(Course);
    }

    public void setCourse(String course) {
        Course = byteName(course);
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public LocalDateTime getTimeStarted() {
        return TimeStarted;
    }

    public int getKidNumber() {
        return KidNumber;
    }

    public void setKidNumber(int kidNumber) {
        KidNumber = kidNumber;
    }

    public int getAdultNumber() {
        return AdultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        AdultNumber = adultNumber;
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
