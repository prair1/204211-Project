package AppUI;

import AppModel.TableBooking;
import AppService.TableManager;
import AppUtil.Text;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLControllerBooked implements Initializable {

    @FXML
    private Label amountLab;
    @FXML
    private Label adultLab;
    @FXML
    private Label kidLab;
    @FXML
    private JFXButton backBtn;
    @FXML
    private JFXButton activeBtn;
    @FXML
    private Label ANumLab;
    @FXML
    private Label KNumLab;
    @FXML
    private Label nameLab;
    @FXML
    private Label timeLab;
    @FXML
    private Label cusNameLab;
    @FXML
    private Label dateLab;
    @FXML
    private Label reserveLab;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private Label tbLab;
    @FXML
    private Label tbNumLab;
    @FXML
    private Label courseLab;

    private TableBooking table;

    FXMLControllerBooked(int id) {
        table = (TableBooking) TableManager.i().findById(id);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtn.setOnMouseClicked(e -> goBack());
        cancelBtn.setOnMouseClicked(e -> cancel());
        activeBtn.setOnMouseClicked(e -> start());
        tbNumLab.setText(String.valueOf(table.getTableNum()));
        courseLab.setText(table.getCourse());
        cusNameLab.setText(table.getCustomerName());
        ANumLab.setText(String.valueOf(table.getAdultNumber()));
        KNumLab.setText(String.valueOf(table.getKidNumber()));
        dateLab.setText(table.getCheckinDate());
        reserveLab.setText(table.getCheckinTime());
        tbLab.setText(Text.TTABLE.get());
        nameLab.setText(Text.NAME.get());
        amountLab.setText(Text.AMOUNT.get());
        adultLab.setText(Text.ADULT.get());
        kidLab.setText(Text.KID.get());
        timeLab.setText(Text.TIME.get());
        backBtn.setText(Text.BACK.get());
        cancelBtn.setText(Text.CANCEL.get());
        activeBtn.setText(Text.TOACTIVE.get());
    }

    private void goBack() {
        ((Stage) backBtn.getScene().getWindow()).close();
    }

    private void cancel() {
        TableManager.i().delTableBooking(table.getId());
        goBack();
    }

    private void start() {
        TableManager.i().startTable(table.getId());
        goBack();
    }
}
