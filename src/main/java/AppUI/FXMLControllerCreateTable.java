package AppUI;

import AppModel.Course;
import AppModel.Price;
import AppService.SettingManager;
import AppUtil.Text;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import static AppUtil.Converter.byteName;

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
    JFXComboBox<String> courseCob;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXTextField[] txtFListInt = {adultTxtF, kidTxtF, tbNumTxtF};
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
    }

    @FXML
    void okClicked() {
        boolean isReady = true;
        JFXTextField[] txtFList = {adultTxtF, kidTxtF, tbNumTxtF};
        for (JFXTextField txtF : txtFList) {
            txtF.setStyle("-fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
            if (txtF.getText().isEmpty()) {
                txtF.setStyle("-fx-background-color: rgba(198,40,40,0.2); -fx-text-fill: #fff; -fx-prompt-text-fill:  #626262");
                isReady = false;
            }
        }
    }

    @FXML
    void backClicked() {
        ((Stage)backBtn.getScene().getWindow()).close();
    }
}
