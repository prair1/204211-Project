package AppUI;

import java.net.URL;
import java.util.ResourceBundle;

import AppService.SaverAndLoader;
import AppService.SettingManager;
import AppUtil.Lang;
import AppUtil.Text;
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
        langChange();
    }

    @FXML
    private void THButtonClick() {
        SettingManager.i().setLanguage(Lang.Thai);
        langChange();
    }

    @FXML
    private void ENButtonClick() {
        SettingManager.i().setLanguage(Lang.English);
        langChange();
    }

    private void langChange() {
        StartBtn.setText(Text.START.get());
    }

}
