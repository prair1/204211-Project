package AppUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import AppModel.Course;
import AppService.SaverAndLoader;
import AppService.SettingManager;
import AppUtil.Lang;
import AppUtil.Text;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMLControllerSetting implements Initializable {

    @FXML
    VBox tableBox;

    ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        langChange();
    }

    @FXML
    void addTable() {
        createCourseTable(tableBox.getChildren());
    }

    private void langChange() {

    }

    private Course createCourseTable(ObservableList<Node> node) {
        JFXTextField courseTxtF = new JFXTextField();
        courseTxtF.setStyle("-fx-text-fill: -fx-primarytext;" +
                            "-fx-prompt-text-fill:  #626262;"+
                            "-fx-font-size : 14px;"+
                            "-jfx-focus-color: #ff616f;"+
                            "-jfx-unfocus-color: #c4001d;"+
                            "-fx-min-height: 32;"+
                            "-fx-min-width: 100;"+
                            "-fx-max-height: 32;"+
                            "-fx-max-width: 100;"
                            );
        JFXTextField adultTxtF = new JFXTextField();
        adultTxtF.setStyle("-fx-text-fill: -fx-primarytext;" +
                "-fx-prompt-text-fill:  #626262;"+
                "-fx-font-size : 14px;"+
                "-jfx-focus-color: #ff616f;"+
                "-jfx-unfocus-color: #c4001d;"+
                "-fx-min-height: 32;"+
                "-fx-min-width: 53;"+
                "-fx-max-height: 32;"+
                "-fx-max-width: 53;" +
                "-fx-padding: 50 0 0 0;"




        );


        JFXTextField kidsTxtF = new JFXTextField();
        kidsTxtF.setStyle("-fx-text-fill: -fx-primarytext;" +
                "-fx-prompt-text-fill:  #626262;"+
                "-fx-font-size : 14px;"+
                "-jfx-focus-color: #ff616f;"+
                "-jfx-unfocus-color: #c4001d;"+
                "-fx-min-height: 32;"+
                "-fx-min-width: 53;"+
                "-fx-max-height: 32;"+
                "-fx-max-width: 53;"



        );

        JFXButton deleteBtn = new JFXButton();
        HBox courseBox = new HBox(courseTxtF, adultTxtF, kidsTxtF, deleteBtn;
        // TODO: set margin around here
        node.addAll(courseBox);
        return new Course(courseBox, courseTxtF, adultTxtF, kidsTxtF, deleteBtn);
    }

}
