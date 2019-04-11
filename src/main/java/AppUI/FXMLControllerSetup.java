package AppUI;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import AppService.SaverAndLoader;
import AppService.SettingManager;
import AppUtil.Lang;
import AppUtil.Text;
import JfxApplication.AppLoader;
import JfxApplication.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

    @FXML
    private void StartBtnClick() throws Exception {
        Stage stage = (Stage) StartBtn.getScene().getWindow();

        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "settingScene.fxml", "Setting");
    }

    private void langChange() {
        StartBtn.setText(Text.START.get());
    }

}
