package AppUI;

import AppModel.Table;
import AppModel.TableActive;
import AppModel.TableBooking;
import AppService.SettingManager;
import AppService.TableManager;
import JfxApplication.SceneLoader;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;


public class FXMLControllerMain implements Initializable {
    @FXML
    Label mainLab;
    @FXML
    Label activeLab;
    @FXML
    FlowPane activeFlow;
    @FXML
    FlowPane bookFlow;
    @FXML
    JFXButton newtableBtn;
    @FXML
    JFXButton newbookBtn;
    @FXML
    JFXButton settingBtn;
    @FXML
    AnchorPane apPane;
    @FXML
    StackPane spPane;
    @FXML
    VBox aVbox;
    @FXML
    VBox bVbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableManager.i().getFile();
        newbookBtn.setStyle(" -fx-font-family:  fontello;");
        newtableBtn.setStyle(" -fx-font-family:  fontello;");
        settingBtn.setStyle(" -fx-font-family:  fontello;");
        reloadActive();
        reloadBooked();
        spPane.widthProperty().addListener(e -> {
            double w = spPane.getWidth() - 1000;
            apPane.setPrefWidth(20 + w/5);
            aVbox.setMinWidth(505 + w/3);
            aVbox.setMaxWidth(500 + w/3);
            bVbox.setMinWidth(505 + w/3);
            bVbox.setMaxWidth(500 + w/3);
            activeFlow.setMinWidth(505 + w/3);
            activeFlow.setMaxWidth(500 + w/3);
            bookFlow.setMinWidth(505 + w/3);
            bookFlow.setMaxWidth(510 + w/3);

        });
    }

    @FXML
    void addActive() {
        Stage stage = new Stage();
        Stage currStage = (Stage) newtableBtn.getScene().getWindow();
        stage.initOwner(currStage);
        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "tCreateTableScene.fxml", false);
        stage.setTitle("Create");
        stage.setOnHiding(e -> reloadActive());
        stage.show();
    }

    @FXML
    void toSetting() {
        Stage stage = (Stage) newtableBtn.getScene().getWindow();
        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "settingScene.fxml", true, "styles.css", newtableBtn.getScene().getWidth(), newtableBtn.getScene().getHeight());
        stage.show();
    }

    private void reloadActive() {
        activeFlow.getChildren().clear();
        int i = 0;
        for (Map.Entry<Integer, TableActive> table: TableManager.i().getTableActives().entrySet()) {
            createActiveTable(table.getKey(), i);
            i++;
        }
    }

    private void createActiveTable(int id, int index) {
        JFXButton btn= createTableBtn(id, activeFlow, "#0277bd");
        btn.setOpacity(0);
        btn.setOnMouseClicked(e -> openCheckBill(id));
        FadeTransition ft = new FadeTransition(Duration.millis(500), btn);
        ft.setDelay(Duration.millis(100*index));
        ft.setFromValue(0);
        ft.setToValue(1);

        ft.play();
    }

    private void openCheckBill(int id) {
        Stage stage = new Stage();
        Stage currStage = (Stage) newtableBtn.getScene().getWindow();
        stage.initOwner(currStage);
        SceneLoader loader = new SceneLoader();
        FXMLControllerCheckBill cont= new FXMLControllerCheckBill(id);
        loader.Load(stage, "tCheckbillScene.fxml", false, "Com-text.css", cont);
        stage.setTitle("Info");
        stage.setOnHiding(e -> reloadActive());
        stage.show();
    }

    @FXML
    void addBooking() {
        Stage stage = new Stage();
        Stage currStage = (Stage) newbookBtn.getScene().getWindow();
        stage.initOwner(currStage);
        SceneLoader loader = new SceneLoader();
        loader.Load(stage, "tBookingScene.fxml", false);
        stage.setTitle("Booking");
        stage.setOnHiding(e -> reloadBooked());
        stage.show();
    }

    private void createBookTable(int id, int index) {
        JFXButton btn= createTableBtn(id, bookFlow, "#00695c");
        btn.setOpacity(0);
        btn.setOnMouseClicked(e -> openBooked(id));
        FadeTransition ft = new FadeTransition(Duration.millis(500), btn);
        ft.setDelay(Duration.millis(100*index));
        ft.setFromValue(0);
        ft.setToValue(1);

        ft.play();
    }

    private void openBooked(int id) {
        Stage stage = new Stage();
        Stage currStage = (Stage) newbookBtn.getScene().getWindow();
        stage.initOwner(currStage);
        SceneLoader loader = new SceneLoader();
        FXMLControllerBooked cont= new FXMLControllerBooked(id);
        loader.Load(stage, "tBookedScene.fxml", false, "Com-text.css", cont);
        stage.setTitle("Info");
        stage.setOnHiding(e -> {
            reloadBooked();
            reloadActive();
        });
        stage.show();
    }

    private void reloadBooked() {
        bookFlow.getChildren().clear();
        int i = 0;
        for (Map.Entry<Integer, TableBooking> table: TableManager.i().getTableBookings().entrySet()) {
            createBookTable(table.getKey(), i);
            i++;
        }
    }

    private JFXButton createTableBtn(int id, FlowPane flowPane, String btnColor) {
        ObservableList<Node> nodes = flowPane.getChildren();

        Label nameLab = new Label(String.valueOf(TableManager.i().findById(id).getTableNum()));
        nameLab.setStyle("-fx-font-size: 18px;" +
                "-fx-text-fill: #ffffff");


        Label timeSpLab;
        try {
            timeSpLab = new Label(TableManager.i().findById(id).getTimeLab().getText());
        }
        catch (Exception e) {
            timeSpLab = new Label();
        }
        TableManager.i().findById(id).setTimeLab(timeSpLab);

        timeSpLab.setStyle("-fx-font-size: 10px;" +
                "-fx-text-fill: #ffffff;" +
                "-fx-text-alignment: center");

        VBox theBox = new VBox(nameLab, timeSpLab);
        theBox.setPrefSize(80, 80);
        theBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(nameLab, new Insets(10, 0, 0, 0));
        VBox.setMargin(timeSpLab, new Insets(5, 0, 0, 0));

        JFXButton tableBtn = new JFXButton();
        tableBtn.setGraphic(theBox);
        tableBtn.setPrefSize(80, 80);
        tableBtn.setAlignment(Pos.CENTER_LEFT);
        tableBtn.setText("");
        tableBtn.setStyle("-fx-background-color:" + btnColor);
        FlowPane.setMargin(tableBtn, new Insets(20, 20, 0, 0));
        nodes.add(tableBtn);
        return tableBtn;
    }
}
