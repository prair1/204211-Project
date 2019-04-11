package JfxApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {

    public void Load(Stage stage, String path, String title) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle(title);
        stage.setScene(scene);

    }
}
