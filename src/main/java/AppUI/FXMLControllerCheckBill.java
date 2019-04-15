package AppUI;

import AppModel.TableActive;
import AppService.Logger;
import AppService.SettingManager;
import AppService.TableManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLControllerCheckBill implements Initializable {

    @FXML
    Label courseTxtLab;
    @FXML
    Label timeLab;
    @FXML
    Label fineLab;
    @FXML
    Label serviceChargeLab;
    @FXML
    Label adultLab;
    @FXML
    Label kidNumLab;
    @FXML
    Label adultNumLab;
    @FXML
    Label kidLab;
    @FXML
    Label totalLab;
    @FXML
    JFXButton backBtn;
    @FXML
    JFXButton stopNBillBtn;
    @FXML
    Label showFineLab;
    @FXML
    Label showSCPerLab;
    @FXML
    Label showSCLab;
    @FXML
    Label showTotalLab;
    @FXML
    JFXTextField otherFineAmountTxtF;
    @FXML
    JFXTextField otherFineTxtF;
    @FXML
    Label totalTimeLab;
    @FXML
    Label adultPriceLab;
    @FXML
    Label kidPriceLab;
    @FXML
    Label overTimeLab;
    @FXML
    Label tbLab;
    @FXML
    Label tbNameLab;
    @FXML
    Label courseLab;

    TableActive table;

    FXMLControllerCheckBill(int id) {
        table = (TableActive) TableManager.i().findById(id);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // region table Label
        tbNameLab.setText(String.valueOf(table.getTableNum()));
        courseLab.setText(table.getType());
        adultNumLab.setText(String.valueOf(table.getAdultHeads()));
        kidNumLab.setText(String.valueOf(table.getKidHeads()));
        adultPriceLab.setText(String.valueOf(table.calAdultsPrice()));
        kidPriceLab.setText(String.valueOf(table.calKidsPrice()));
        // endregion

        backBtn.setOnMouseClicked(e -> goBack());
        if (SettingManager.i().isLimitTime()) {
            if (table.isFinished()) {
                stopTimer();
            }
            else {
                stopNBillBtn.setText("stop");
                stopNBillBtn.setStyle("-fx-background-color: #af4444");
                stopNBillBtn.setOnMouseClicked(e -> stopTimer());
                totalTimeLab.setText("pls stop clock");
                showSCLab.setVisible(false);
                showTotalLab.setVisible(false);
                otherFineAmountTxtF.setDisable(true);
            }
        }
        else {
            stopNBillBtn.setText("end");
            stopNBillBtn.setStyle("-fx-background-color: #14ebc2");
            stopNBillBtn.setOnMouseClicked(e -> endTable());
            fineLab.setVisible(false);
            overTimeLab.setVisible(false);
            showFineLab.setVisible(false);
            timeLab.setVisible(false);
            totalTimeLab.setVisible(false);
            showSCLab.setText(String.valueOf(calSC()));
            showTotalLab.setText(String.valueOf(calFinalPrice()));
        }
        showSCPerLab.setText(String.valueOf(SettingManager.i().getServiceCharge()));
        otherFineAmountTxtF.textProperty().addListener(e -> amountChange());
    }

    private void stopTimer() {
        table.setFinished();
        totalTimeLab.setText(table.getTxtTime('t'));
        overTimeLab.setText(table.getTxtTime('o'));
        showFineLab.setText(String.valueOf(table.calExcessFine()));
        showSCLab.setVisible(true);
        showSCLab.setText(String.valueOf(calSC()));
        showTotalLab.setVisible(true);
        showTotalLab.setText(String.valueOf(calFinalPrice()));
        otherFineAmountTxtF.setDisable(false);
        stopNBillBtn.setText("end");
        stopNBillBtn.setStyle("-fx-background-color: #14ebc2");
        stopNBillBtn.setOnMouseClicked(e -> endTable());

    }

    private void endTable() {
        table.setFinished();
        table.setTotalPrice(calFinalPrice());
        table.toLog();
        TableManager.i().delTableActive(table.getId());
        goBack();
    }

    private double calSC() {
        return calPrice() * (SettingManager.i().getServiceCharge() / 100);
    }

    private double calPrice() {
        if (SettingManager.i().isLimitTime())
            return table.calAdultsPrice() + table.calKidsPrice() + table.calExcessFine();
        else
            return table.calAdultsPrice() + table.calKidsPrice();
    }

    private double calFinalPrice() {
        try {
            return calSC() + calPrice() + Double.parseDouble(otherFineAmountTxtF.getText());
        }
        catch (Exception e) {
            return calSC() + calPrice();
        }

    }

    private void amountChange() {
        showTotalLab.setText(String.valueOf(calFinalPrice()));
    }

    private void goBack() {
        ((Stage)backBtn.getScene().getWindow()).close();
    }
}
