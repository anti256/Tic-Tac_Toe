package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane mainWindow;
    @FXML
    Button[][] buttonArray = new Button[25][25];
    //ArrayList<Points> compPoints = new ArrayList<>();
    HashMap<Integer, Integer> compPoints = new HashMap<>();
    HashMap<Integer, Integer> userPoints = new HashMap<>();
    //ArrayList<Points> userPoints = new ArrayList<>();
    String whoseMove;

    @FXML
    void btnClick(ActionEvent event) {
        if (((Button)event.getSource()).getText().equals("X")){
            ((Button)event.getSource()).setText("O");
       ((Button)event.getSource()).setStyle("-fx-text-fill: #ff0000");}
                else {((Button)event.getSource()).setText("X");
            ((Button)event.getSource()).setStyle("-fx-text-fill: #0000ff");}

    }

    @FXML
    void initialize(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Button btn = new Button(" ");
                btn.setAlignment(Pos.CENTER);
                btn.setContentDisplay(ContentDisplay.CENTER);
                btn.setPrefSize(30.0,30.0);
                btn.setMinSize(30.0, 30.0);
                btn.setMaxSize(30.0, 30.0);
                btn.setMnemonicParsing(false);
                btn.setTextAlignment(TextAlignment.CENTER);
                btn.setFont(Font.font("Arial Narrow", 14.0));
                btn.setOnAction(this::btnClick);
                //btn.setText(String.valueOf(i));
                //btn.setText(" ");
                grid.add(btn, i, j);
                //mainWindow.;
                btn.setVisible(true);
                buttonArray[i][j] = btn;
            }

        }
    }//end of initialize()

    @FXML
    void newGame(ActionEvent event) {
        //очищаем игровое поле
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                buttonArray[i][j].setText(" ");
            }
        }
    userPoints.clear();
    compPoints.clear();
    buttonArray[13][13].setText("X");
    compPoints.put(13, 13);
    whoseMove = "human";

    }

}
