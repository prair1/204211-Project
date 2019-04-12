package JfxApplication;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneLoader {

    public void Load(Stage stage, String path, boolean resizeAble) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setResizable(resizeAble);
        stage.setScene(scene);
    }
}
