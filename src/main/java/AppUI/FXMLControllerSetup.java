package AppUI;

import AppService.SettingManager;
import AppUtil.Lang;
import AppUtil.Text;
import JfxApplication.SceneLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLControllerSetup implements Initializable {

    @FXML
    Button startBtn;

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

    @FXML
    private void startBtnClick() {
        Stage stage = (Stage) startBtn.getScene().getWindow();

        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "settingScene.fxml", true, "styles.css");
    }

    private void langChange() {
        startBtn.setText(Text.START.get());
    }

}
