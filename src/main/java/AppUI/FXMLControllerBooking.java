package AppUI;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
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
    JFXDatePicker dateP;
    @FXML
    JFXTimePicker timeP;
    @FXML
    Label tbLab;
    @FXML
    JFXTextField tbNumTxtF;
    @FXML
    JFXComboBox courseCob;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
