package AppUI;

import JfxApplication.SceneLoader;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class FXMLControllerMain implements Initializable {
    @FXML
    Label mainLab;
    @FXML
    Label activeLab;
    @FXML
    Label bookLab;
    @FXML
    FlowPane activeFlow;
    @FXML
    FlowPane bookFlow;
    @FXML
    JFXButton newtableBtn;
    @FXML
    JFXButton newbookBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void addActive() throws Exception {
        Stage stage = new Stage();
        Stage currStage = (Stage) newtableBtn.getScene().getWindow();
        stage.initOwner(currStage);
        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "tCreateTableScene.fxml", true);
        stage.show();
    }

    private void createActiveTable() {
        ObservableList<Node> nodes = statFlow.getChildren();



        Label nameLab = new Label("B1");
        nameLab.setStyle("-fx-font-size: 18px;" +
                "-fx-text-fill: #ffffff");

        Label timeSpLab = new Label("15.00");
        timeSpLab.setStyle("-fx-font-size: 18px;" +
                "-fx-text-fill: #000000");

        VBox startBox = new VBox(nameLab, timeSpLab);
        startBox.setPrefSize(80, 80);
        startBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(nameLab, new Insets(10, 0, 0, 0));
        VBox.setMargin(timeSpLab, new Insets(10, 0, 0, 0));

        JFXButton tableBtn = new JFXButton();
        tableBtn.setGraphic(startBox);
        tableBtn.setPrefSize(80, 80);
        tableBtn.setAlignment(Pos.CENTER_LEFT);
        tableBtn.setText("");
        tableBtn.setStyle("-fx-background-color:  #ff6666");
        FlowPane.setMargin(tableBtn, new Insets(20, 20, 0, 0));
        nodes.add(tableBtn);
    }

  /*  private void createBookTable () {


        Label bnameLab = new Label();
        nameLab.setStyle("-fx-font-size: 18px;" +
                "-fx-text-fill: #ffffff");

        Label checkLab = new Label();
        timeSpLab.setStyle("-fx-font-size: 18px;" +
                "-fx-text-fill: #000000");

        VBox bookBox = new VBox(nameLab, timeSpLab);
        bookBox.setPrefSize(80, 80);
        bookBox.setAlignment(Pos.TOP_CENTER);
        bookBox.setMargin(bnameLab, new Insets(10, 0, 0, 0));
        bookBox.setMargin(checkLab, new Insets(10, 0, 0, 0));

        JFXButton bookBtn = new JFXButton(statBox);
        bookBtn.setPrefSize(80, 80);
        bookBtn.setText(" ");
        bookBtn.setStyle("-fx-background-color:   #82E1B1");
        FlowPane.setMargin(tableBtn, new Insets(20, 20, 0, 0));



    }*/
}
