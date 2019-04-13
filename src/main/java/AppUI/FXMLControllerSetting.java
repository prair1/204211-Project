package AppUI;

import AppModel.Course;
import AppModel.Price;
import AppService.SettingManager;
import AppUtil.Lang;
import AppUtil.Text;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

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
    JFXTextField tableTxtF;
    @FXML
    JFXTextField thourTxtF;
    @FXML
    JFXTextField tminTxtF;
    @FXML
    JFXTextField tsecTxtF;
    @FXML
    JFXTextField excessTxtF;
    @FXML
    JFXTextField ehourTxtF;
    @FXML
    JFXTextField eminTxtF;
    @FXML
    JFXTextField esecTxtF;
    @FXML
    JFXTextField scTxtF;

    @FXML
    Label col1;
    @FXML
    Label col2;
    @FXML
    Label col3;
    @FXML
    Label col4;

    @FXML
    JFXButton addBtn;

    @FXML
    JFXButton backBtn;
    @FXML
    JFXButton saveBtn;
    @FXML
    Label messageLab;

    private String priceBoxStyle = "-fx-text-fill: -fx-primarytext;" +
            "-fx-prompt-text-fill:  #626262;" +
            "-fx-font-size : 14px;" +
            "-jfx-focus-color: #ff616f;" +
            "-jfx-unfocus-color: #c4001d;" +
            "-fx-min-height: 32;" +
            "-fx-min-width: 53;" +
            "-fx-max-height: 32;" +
            "-fx-max-width: 53;";

    private String courseBoxStyle = "-fx-text-fill: -fx-primarytext;" +
            "-fx-prompt-text-fill:  #626262;" +
            "-fx-font-size : 14px;" +
            "-jfx-focus-color: #ff616f;" +
            "-jfx-unfocus-color: #c4001d;" +
            "-fx-min-height: 32;" +
            "-fx-min-width: 100;" +
            "-fx-max-height: 32;" +
            "-fx-max-width: 100;";

    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        langChange();
        langCob.getItems().addAll("ไทย", "English");
        langCob.getSelectionModel().select(SettingManager.i().getLanguage().ordinal());
        JFXTextField[] txtFListDouble = {excessTxtF, scTxtF};
        for (JFXTextField txtF : txtFListDouble) {
            txtF.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[\\d.]*")) {
                    txtF.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            });
        }
        JFXTextField[] txtFListInt = {tableTxtF, thourTxtF, tminTxtF, tsecTxtF, ehourTxtF, eminTxtF, esecTxtF};
        for (JFXTextField txtF : txtFListInt) {
            txtF.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    txtF.setText(newValue.replaceAll("\\D", ""));
                }
            });
        }
        //get back from setting
        tableTxtF.setText(String.valueOf(SettingManager.i().getTableCount()));
        timitTog.setSelected(SettingManager.i().isLimitTime());
        if (SettingManager.i().isLimitTime()) {
            togOn();
        }
        timeLimitToggle();
        scTxtF.setText(String.valueOf(SettingManager.i().getServiceCharge()));
        for (Map.Entry<String, Price> pm : SettingManager.i().getPriceMap().entrySet()) {
            Course newCourse = addCourseTable();
            newCourse.getCourseTxtF().setText(pm.getValue().getName());
            newCourse.getAdultTxtF().setText(String.valueOf(pm.getValue().getPriceAdult()));
            newCourse.getKidsTxtF().setText(String.valueOf(pm.getValue().getPriceKids()));
        }

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
        boolean isReady = true;
        messageLab.setText("[MessageText]");
        messageLab.setVisible(false);
        // region text checking
        JFXTextField[] txtFList = {tableTxtF, scTxtF};
        for (JFXTextField txtF : txtFList) {
            txtF.setStyle("-fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
            if (txtF.getText().isEmpty()) {
                txtF.setStyle("-fx-background-color: #c33936; -fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
                isReady = false;
                messageLab.setText(Text.MSG_EMPTY.get());
                messageLab.setVisible(true);
            }
        }
        if (timitTog.isSelected()) {
            JFXTextField[] txtFList2 = {thourTxtF, tminTxtF, tsecTxtF, excessTxtF, ehourTxtF, eminTxtF, esecTxtF};
            for (JFXTextField txtF : txtFList2) {
                txtF.setStyle("-fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
                if (txtF.getText().isEmpty()) {
                    txtF.setStyle("-fx-background-color: #c33936; -fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
                    isReady = false;
                    messageLab.setText(Text.MSG_EMPTY.get());
                    messageLab.setVisible(true);
                }
            }
        }
        addBtn.setStyle("-fx-background-color: #464646; -fx-font-family:  fontello;");
        if (courseList.isEmpty()) {
            if (!isReady)
                messageLab.setText(Text.MSG_EMPNOC.get());
            else
                messageLab.setText(Text.MSG_NOC.get());
            messageLab.setVisible(true);
            isReady = false;
            addBtn.setStyle("-fx-background-color: #ff616f; -fx-font-family:  fontello;");
        }
        else {
            for (Course course : courseList) {
                course.getCourseTxtF().setStyle(courseBoxStyle + "-fx-background-color: #393939");
                if (course.getCourseTxtF().getText().isEmpty()) {
                    course.getCourseTxtF().setStyle(courseBoxStyle + "-fx-background-color: #c33936");
                    isReady = false;
                    messageLab.setText(Text.MSG_EMPTY.get());
                    messageLab.setVisible(true);
                }
                course.getAdultTxtF().setStyle(priceBoxStyle + "-fx-background-color: #393939");
                if (course.getAdultTxtF().getText().isEmpty()) {
                    course.getAdultTxtF().setStyle(priceBoxStyle + "-fx-background-color: #c33936");
                    isReady = false;
                    messageLab.setText(Text.MSG_EMPTY.get());
                    messageLab.setVisible(true);
                }
                course.getKidsTxtF().setStyle(priceBoxStyle + "-fx-background-color: #393939");
                if (course.getKidsTxtF().getText().isEmpty()) {
                    course.getKidsTxtF().setStyle(priceBoxStyle + "-fx-background-color: #c33936");
                    isReady = false;
                    messageLab.setText(Text.MSG_EMPTY.get());
                    messageLab.setVisible(true);
                }
            }
        }
        // endregion

        if (isReady) {
            SettingManager.i().setTableCount(Integer.parseInt(tableTxtF.getText()));
            SettingManager.i().setLimitTime(timitTog.isSelected());
            if (timitTog.isSelected()) {
                SettingManager.i().setTimeLimit(strToSecond(thourTxtF.getText(), tminTxtF.getText(), tsecTxtF.getText()));
                SettingManager.i().setExcessFine(Double.parseDouble(excessTxtF.getText()));
                SettingManager.i().setTimePerExcess(strToSecond(ehourTxtF.getText(), eminTxtF.getText(), esecTxtF.getText()));
            }

            SettingManager.i().setServiceCharge(Double.parseDouble(scTxtF.getText()));
            SettingManager.i().clearPrice();
            for (Course course : courseList) {
                SettingManager.i().addPrice(course.getCourseTxtF().getText(),
                        Double.parseDouble(course.getAdultTxtF().getText()),
                        Double.parseDouble(course.getKidsTxtF().getText()));
            }
        }
    }

    @FXML
    void timeLimitToggle() {
        if (timitTog.isSelected()) {
            thourTxtF.setDisable(false);
            tminTxtF.setDisable(false);
            tsecTxtF.setDisable(false);
            excessLab.setDisable(false);
            excessTxtF.setDisable(false);
            perLab.setDisable(false);
            ehourTxtF.setDisable(false);
            eminTxtF.setDisable(false);
            esecTxtF.setDisable(false);
            col1.setDisable(false);
            col2.setDisable(false);
            col3.setDisable(false);
            col4.setDisable(false);
            togOn();
        }
        else {
            thourTxtF.setDisable(true);
            tminTxtF.setDisable(true);
            tsecTxtF.setDisable(true);
            excessLab.setDisable(true);
            excessTxtF.setDisable(true);
            perLab.setDisable(true);
            ehourTxtF.setDisable(true);
            eminTxtF.setDisable(true);
            esecTxtF.setDisable(true);
            col1.setDisable(true);
            col2.setDisable(true);
            col3.setDisable(true);
            col4.setDisable(true);
        }
    }

    private void togOn() {
        String[] tiLim = secondToStr(SettingManager.i().getTimeLimit());
        thourTxtF.setText(tiLim[0]);
        tminTxtF.setText(tiLim[1]);
        tsecTxtF.setText(tiLim[2]);
        excessTxtF.setText(String.valueOf(SettingManager.i().getExcessFine()));
        String[] tiEx = secondToStr(SettingManager.i().getTimePerExcess());
        ehourTxtF.setText(tiEx[0]);
        eminTxtF.setText(tiEx[1]);
        esecTxtF.setText(tiEx[2]);
    }

    @FXML
    void getTableCountField() {
        System.out.println("Hi");
        System.out.println(tableTxtF.getText());
    }

    @FXML
    Course addCourseTable() {
        Course newCourse = createCourseTable();
        courseList.add(newCourse);
        return newCourse;
    }

    private void delCourseTable(Course currBox) {
        ObservableList<Node> nodes = tableBox.getChildren();

        nodes.removeAll(currBox.getKidsTxtF(),
                currBox.getAdultTxtF(),
                currBox.getCourseTxtF(),
                currBox.getDeleteBtn(),
                currBox.getCourseBox());
        courseList.remove(currBox);
        SettingManager.i().delPrice(currBox.getCourseTxtF().getText());
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
        backBtn.setText(Text.BACK.get());
        saveBtn.setText(Text.SAVE.get());
    }

    private Course createCourseTable() {

        ObservableList<Node> nodes = tableBox.getChildren();

        JFXTextField courseTxtF = new JFXTextField();
        courseTxtF.setStyle(courseBoxStyle);
        courseTxtF.setPromptText(Text.COURSE.get());
        courseTxtF.setLabelFloat(true);


        JFXTextField adultTxtF = new JFXTextField();
        adultTxtF.setStyle(priceBoxStyle);
        adultTxtF.setPromptText(Text.ADULT.get());
        adultTxtF.setLabelFloat(true);


        JFXTextField kidsTxtF = new JFXTextField();
        kidsTxtF.setStyle(priceBoxStyle);
        kidsTxtF.setPromptText(Text.KID.get());
        kidsTxtF.setLabelFloat(true);

        JFXButton deleteBtn = new JFXButton("\uE800");
        deleteBtn.setStyle("-fx-text-fill: -fx-primarytext;" +
                "-fx-font-size : 14px;" +
                "-fx-font-family: fontello;"
        );

        JFXTextField[] txtFList = {adultTxtF, kidsTxtF};
        for (JFXTextField txtF : txtFList) {
            txtF.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[\\d.]*")) {
                    txtF.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            });
        }

        HBox courseBox = new HBox(courseTxtF, adultTxtF, kidsTxtF, deleteBtn);
        HBox.setMargin(courseTxtF, new Insets(27, 0, 0, 0));
        HBox.setMargin(adultTxtF, new Insets(27, 0, 0, 50));
        HBox.setMargin(kidsTxtF, new Insets(27, 0, 0, 20));
        HBox.setMargin(deleteBtn, new Insets(27, 0, 0, 20));

        nodes.addAll(courseBox);
        Course self = new Course(courseBox, courseTxtF, adultTxtF, kidsTxtF, deleteBtn);
        deleteBtn.setOnMouseClicked(e -> delCourseTable(self));
        return self;


    }

    private long strToSecond(String hour, String minute, String second) {
        return (Long.parseLong(hour) * 3600) + (Long.parseLong(minute) * 60) + Long.parseLong(second);
    }

    private String[] secondToStr(long second) {
        long hour = second / 3600;
        second = second - hour * 3600;
        long min = second / 60;
        second = second - min * 60;
        return new String[] {String.valueOf(hour), String.valueOf(min), String.valueOf(second)};
    }
}
