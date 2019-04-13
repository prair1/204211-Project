package AppUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLControllerCreateTable implements Initializable {

    @FXML
    Label amountLab;
    @FXML
    Label adultLab;
    @FXML
    Label kidLab;
    @FXML
    JFXButton backBtn;
    @FXML
    JFXButton okBtn;
    @FXML
    JFXTextField adultTxtF;
    @FXML
    JFXTextField kidTxtF;
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
