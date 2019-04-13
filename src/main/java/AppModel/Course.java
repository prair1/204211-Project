package AppModel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.HBox;

public class Course {
    private HBox courseBox;
    private JFXTextField courseTxtF;
    private JFXTextField adultTxtF;
    private JFXTextField kidsTxtF;
    private JFXButton deleteBtn;

    public Course(HBox courseBox, JFXTextField courseTxtF, JFXTextField adultTxtF, JFXTextField kidsTxtF, JFXButton deleteBtn) {
        this.courseBox = courseBox;
        this.courseTxtF = courseTxtF;
        this.adultTxtF = adultTxtF;
        this.kidsTxtF = kidsTxtF;
        this.deleteBtn = deleteBtn;
    }

    public HBox getCourseBox() {
        return courseBox;
    }

    public JFXTextField getCourseTxtF() {
        return courseTxtF;
    }

    public JFXTextField getAdultTxtF() {
        return adultTxtF;
    }

    public JFXTextField getKidsTxtF() {
        return kidsTxtF;
    }

    public JFXButton getDeleteBtn() {
        return deleteBtn;
    }
}
