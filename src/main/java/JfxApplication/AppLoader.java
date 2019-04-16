package JfxApplication;

import AppService.SettingManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class AppLoader extends Application {

    
    @Override
    public void start(Stage stage) {
        SceneLoader loader = new SceneLoader();
        Font.loadFont(AppLoader.class.getResource("fontello.ttf").toExternalForm(), 16.0);
        loader.Load(stage,"setupScene.fxml", false);
        stage.setTitle("Table Manager");
        stage.setOnHidden(e -> Platform.exit());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
