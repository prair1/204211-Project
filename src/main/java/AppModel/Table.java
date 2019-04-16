package AppModel;

import javafx.scene.control.Label;

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

    public String getCourse() {
        return strFromByte(Course);
    }

    public void setCourse(String course) {
        Course = byteName(course);
    }

    public int getKidNumber() {
        return KidNumber;
    }

    public int getAdultNumber() {
        return AdultNumber;
    }

    public Label getTimeLab() {
        return TimeLab;
    }

    public void setTimeLab(Label timeLab) {
        TimeLab = timeLab;
        updateTime();
    }

    //endregion

    public abstract long getTime();

    abstract void updateTime();
}
