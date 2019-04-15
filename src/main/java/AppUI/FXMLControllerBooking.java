package AppUI;

import AppModel.Price;
import AppService.SettingManager;
import AppService.TableManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.ResourceBundle;

public class FXMLControllerBooking implements Initializable {

    @FXML
    Label amountLab;
    @FXML
    Label adultLab;
    @FXML
    Label kidLab;
    @FXML
    JFXButton backBtn;
    @FXML
    JFXButton bookBtn;
    @FXML
    JFXTextField adultTxtF;
    @FXML
    JFXTextField kidTxtF;
    @FXML
    Label nameLab;
    @FXML
    JFXTextField nameTxtF;
    @FXML
    Label timeLab;
    @FXML
    JFXComboBox<Integer> dayCob;
    @FXML
    JFXComboBox<String> monthCob;
    @FXML
    JFXComboBox<String> yearCob;
    @FXML
    JFXComboBox<String> hourCob;
    @FXML
    JFXComboBox<String> minCob;
    @FXML
    Label tbLab;
    @FXML
    JFXComboBox<Integer> tbNumCob;
    @FXML
    JFXComboBox<String> courseCob;
    @FXML
    Label errorLab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbNumCob.getItems().addAll(TableManager.i().getTableNumSet());
        tbNumCob.getSelectionModel().selectFirst();
        JFXTextField[] txtFList = {adultTxtF, kidTxtF};
        for (JFXTextField txtF : txtFList)
            txtF.setStyle("-fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
        JFXTextField[] txtFListInt = {adultTxtF, kidTxtF};
        for (JFXTextField txtF : txtFListInt) {
            txtF.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    txtF.setText(newValue.replaceAll("\\D", ""));
                }
            });
        }
        for (Map.Entry<String, Price> pm : SettingManager.i().getPriceMap().entrySet()) {
            courseCob.getItems().add(pm.getValue().getName());
        }
        courseCob.getSelectionModel().selectFirst();
        LocalDateTime now = LocalDateTime.now();
        for (int i = 1; i <= 12; i++) {
            monthCob.getItems().add(String.valueOf(i));
        }
        for (int i = 0; i < 3; i++) {
            yearCob.getItems().add(String.valueOf(now.getYear() + i));
        }
        monthCob.getSelectionModel().select(now.getMonthValue() - 1);
        yearCob.getSelectionModel().selectFirst();
        monthCob.valueProperty().addListener(e -> updateDay());
        yearCob.valueProperty().addListener(e -> updateDay());
        updateDay();
        dayCob.getSelectionModel().select(now.getDayOfMonth() - 1);
        for (int i = 0; i <= 23; i++) {
            hourCob.getItems().add(String.format("%02d", i));
        }
        for (int i = 0; i <= 59; i++) {
            minCob.getItems().add(String.format("%02d", i));
        }
        hourCob.getSelectionModel().select(now.getHour());
        minCob.getSelectionModel().select(now.getMinute());
    }


    @FXML
    void bookClicked() {
        boolean isReady = true;
        JFXTextField[] txtFList = {nameTxtF, adultTxtF, kidTxtF};
        for (JFXTextField txtF : txtFList) {
            txtF.setStyle("-fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
            if (txtF.getText().isEmpty()) {
                txtF.setStyle("-fx-background-color: rgba(198,40,40,0.2); -fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
                errorLab.setText("Where is people");
                errorLab.setVisible(true);
                isReady = false;

            }
        }
        LocalDateTime timeCheckin = LocalDateTime.of(Integer.parseInt(yearCob.getValue()),
                Integer.parseInt(monthCob.getValue()),
                dayCob.getValue(),
                Integer.parseInt(hourCob.getValue()),
                Integer.parseInt(minCob.getValue()));
        JFXComboBox[] cob = {yearCob, monthCob, dayCob, hourCob, minCob};
        for (JFXComboBox box : cob) {
            box.setStyle("-fx-background-color: transparent;");
        }
        if (timeCheckin.isBefore(LocalDateTime.now())) {
            for (JFXComboBox box : cob) {
                box.setStyle("-fx-background-color: rgba(198,40,40,0.2);");
            }
            errorLab.setText(isReady ? "Oh no Time Invalid" : "Multiple Error!");
            errorLab.setVisible(true);
            isReady = false;
        }

        if (isReady) {
            TableManager.i().newTableBooking(tbNumCob.getValue(),
                    courseCob.getValue(),
                    nameTxtF.getText(),
                    Integer.parseInt(kidTxtF.getText()),
                    Integer.parseInt(adultTxtF.getText()),
                    timeCheckin);
            goBack();
        }

    }

    private void updateDay() {
        dayCob.getItems().clear();
        int month = Integer.parseInt(monthCob.getValue());
        int year = Integer.parseInt(yearCob.getValue());
        int day;
        switch (month) {
            case 2:
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            day = 29;
                            break;
                        }
                        day = 28;
                        break;
                    }
                    day = 29;
                    break;
                }
                day = 28;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            default:
                day = 30;
        }
        for (int i = 1; i <= day; i++) {
            dayCob.getItems().add(i);
        }
        dayCob.getSelectionModel().selectFirst();
    }

    @FXML
    void goBack() {
        ((Stage) backBtn.getScene().getWindow()).close();
    }
}
