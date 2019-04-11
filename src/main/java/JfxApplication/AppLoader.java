package JfxApplication;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppLoader extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "setupScene.fxml", false);
        stage.setTitle("Table Manager");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
