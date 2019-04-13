package AppUI;

package AppUI;

import AppModel.Course;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;



public class FXMLControllerMain implements Initializable {


    private void createStatTable() {



        Label nameLab = new Label();
        nameLab.setStyle("-fx-font-size: 18px;"+
                        "-fx-text-fill: #ffffff");

        Label timeSpLab = new Label();
        timeSpLab.setStyle("-fx-font-size: 18px;"+
                "-fx-text-fill: #000000");

        VBox statBox = new VBox(nameLab,timeSpLab);
        statBox.setPrefSize(80,80);
        statBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(nameLab,new Insets(10,0,0,0));
        VBox.setMargin(timeSpLab,new Insets(10,0,0,0));

        JFXButton tableBtn = new JFXButton(statBox);
        tableBtn.setPrefSize(80,80);
        tableBtn.setText(" ");
        tableBtn.setStyle("-fx-background-color:  #ff6666");





        );
        private void createBookTable() {



            Label nameLab = new Label();
            nameLab.setStyle("-fx-font-size: 18px;"+
                    "-fx-text-fill: #ffffff");

            Label timeSpLab = new Label();
            timeSpLab.setStyle("-fx-font-size: 18px;"+
                    "-fx-text-fill: #000000");

            VBox statBox = new VBox(nameLab,timeSpLab);
            statBox.setPrefSize(80,80);
            statBox.setAlignment(Pos.TOP_CENTER);
            VBox.setMargin(nameLab,new Insets(10,0,0,0));
            VBox.setMargin(timeSpLab,new Insets(10,0,0,0));

            JFXButton tableBtn = new JFXButton(statBox);
            tableBtn.setPrefSize(80,80);
            tableBtn.setText(" ");
            tableBtn.setStyle("-fx-background-color:   #82E1B1");





        );

        FlowPane.setMargin(tableBtn,new Insets(20,20,0,0));


    }

