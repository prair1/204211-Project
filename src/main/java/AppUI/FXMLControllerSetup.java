package AppUI;

import java.net.URL;
import java.util.ResourceBundle;

import AppService.SaverAndLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FXMLControllerSetup implements Initializable {

    @FXML
    Button StartBtn;

    @FXML
    Button THBtn;

    @FXML
    Button ENBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void THButtonClick() {
        StartBtn.setText("เริ่ม");
    }

    @FXML
    private void ENButtonClick() {
        StartBtn.setText("Start");
    }

    private void langChange() {
        StartBtn.setText("Hi")
    }

}
