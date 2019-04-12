package AppUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import AppModel.Course;
import AppService.SettingManager;
import AppUtil.Lang;
import AppUtil.Text;
import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMLControllerSetting implements Initializable {

    @FXML
    VBox tableBox;
    @FXML
    Label setLab;

    @FXML
    Label langLab;
    @FXML
    Label tableLab;
    @FXML
    Label timitLab;
    @FXML
    Label excessLab;
    @FXML
    Label perLab;
    @FXML
    Label scLab;
    @FXML
    Label courseLab;
    @FXML
    Label priceLab;
    @FXML
    JFXToggleButton timitTog;
    @FXML
    JFXComboBox<String> langCob;
    @FXML
    JFXTextField   tableTxtF;
    @FXML
    JFXTextField   thourTxtF;
    @FXML
    JFXTextField   tminTxtF;
    @FXML
    JFXTextField   tsecTxtF;
    @FXML
    JFXTextField   excessTxtF;
    @FXML
    JFXTextField   ehourTxtF;
    @FXML
    JFXTextField   eminTxtF;
    @FXML
    JFXTextField   esecTxtF;
    @FXML
    JFXTextField   scTxtF;

    @FXML
    Label col1;
    @FXML
    Label col2;
    @FXML
    Label col3;
    @FXML
    Label col4;



    ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        langChange();
        langCob.getItems().addAll("ไทย","English");
        langCob.getSelectionModel().select(SettingManager.i().getLanguage().ordinal());
    }

    @FXML
    void changeLanguage() {
        switch (langCob.getValue()) {
            case "ไทย":
                SettingManager.i().setLanguage(Lang.Thai);
                break;
            case "English":
                SettingManager.i().setLanguage(Lang.English);
        }
        langChange();

    }

    @FXML
    void saveBtnClick() {

    }

    @FXML
    void timeLimitToggle() {
        if (timitTog.isSelected()) {

        }
        else {

        }
    }

    @FXML
    void getTableCountField() {
        System.out.println("Hi");
        System.out.println(tableTxtF.getText());
    }

    @FXML
    void addCourseTable() {
        createCourseTable(tableBox.getChildren());
    }

    private void langChange() {
        setLab.setText(Text.SETTING.get());
        langLab.setText(Text.LANGUAGE.get());
        tableLab.setText(Text.TABLE.get());
        timitLab.setText(Text.TIMELIMIT.get());
        excessLab.setText(Text.EXCESSFINE.get());
        perLab.setText(Text.PER.get());
        scLab.setText(Text.SERVICECHARGE.get());
        courseLab.setText(Text.COURSE.get());
        priceLab.setText(Text.PRICE.get());
        tableTxtF.setPromptText(Text.TABLE.get());
        thourTxtF.setPromptText(Text.HOUR.get());
        tminTxtF.setPromptText(Text.MIN.get());
        tsecTxtF.setPromptText(Text.SEC.get());
        excessTxtF.setPromptText(Text.EXCESSFINE.get());
        ehourTxtF.setPromptText(Text.HOUR.get());
        eminTxtF.setPromptText(Text.MIN.get());
        esecTxtF.setPromptText(Text.SEC.get());
        scTxtF.setPromptText(Text.SERVICECHARGE.get());
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
        courseTxtF.setPromptText(Text.COURSE.get());
        courseTxtF.setLabelFloat(true);


        JFXTextField adultTxtF = new JFXTextField();
        adultTxtF.setStyle("-fx-text-fill: -fx-primarytext;" +
                "-fx-prompt-text-fill:  #626262;"+
                "-fx-font-size : 14px;"+
                "-jfx-focus-color: #ff616f;"+
                "-jfx-unfocus-color: #c4001d;"+
                "-fx-min-height: 32;"+
                "-fx-min-width: 53;"+
                "-fx-max-height: 32;"+
                "-fx-max-width: 53;"
        );
        adultTxtF.setPromptText(Text.ADULT.get());
        adultTxtF.setLabelFloat(true);


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
        kidsTxtF.setPromptText(Text.KID.get());
        kidsTxtF.setLabelFloat(true);

        JFXButton deleteBtn = new JFXButton("\uE800");
        deleteBtn.setStyle("-fx-text-fill: -fx-primarytext;"+
                        "-fx-font-size : 14px;"+
                        "-fx-font-family: fontello;"
                      );

        HBox courseBox = new HBox(courseTxtF, adultTxtF, kidsTxtF, deleteBtn);
        HBox.setMargin(adultTxtF,new Insets(0,0,0,50));
        HBox.setMargin(kidsTxtF,new Insets(0,0,0,20));
        HBox.setMargin(deleteBtn,new Insets(5,0,0,20));

        node.addAll(courseBox);
        return new Course(courseBox, courseTxtF, adultTxtF, kidsTxtF, deleteBtn);


    }

}
