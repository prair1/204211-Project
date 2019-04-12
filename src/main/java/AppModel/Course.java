package AppModel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.HBox;

public class Course {
    public HBox courseBox;
    public JFXTextField courseTxtF;
    public JFXTextField adultTxtF;
    public JFXTextField kidsTxtF;
    public JFXButton deleteBtn;

    public Course(HBox courseBox, JFXTextField courseTxtF, JFXTextField adultTxtF, JFXTextField kidsTxtF, JFXButton deleteBtn) {
        this.courseBox = courseBox;
        this.courseTxtF = courseTxtF;
        this.adultTxtF = adultTxtF;
        this.kidsTxtF = kidsTxtF;
        this.deleteBtn = deleteBtn;
    }
}
