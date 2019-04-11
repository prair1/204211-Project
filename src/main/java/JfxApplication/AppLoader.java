package JfxApplication;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLoader extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "setupSceneDark.fxml", "Setting");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
