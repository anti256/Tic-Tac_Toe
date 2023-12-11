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
    //Button[][] buttonArray = new Button[25][25];
    ArrayList<ButtonClass> buttonArray = new ArrayList<>();
    ArrayList<ButtonClass> compPoints = new ArrayList<>();//клетки компьютера
    ArrayList<ButtonClass> userPoints = new ArrayList<>();//клетки человека

    //HashMap<Integer, Integer> compPoints = new HashMap<>();
    //HashMap<Integer, Integer> userPoints = new HashMap<>();
    //ArrayList<Points> userPoints = new ArrayList<>();
    String whoseMove;

    @FXML
    static void btnClick(ActionEvent event) {
        /*if (whoseMove.equals("human")) {
            ((Button)event.getSource()).
            if (compPoints.contains())
        }*/
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
                ButtonClass btnCl = new ButtonClass(new Button(""), i, j);
                buttonArray.add(btnCl);
                btnCl.getButton().setVisible(true);
            }
        }
    }//end of initialize()

    @FXML
    void newGame(ActionEvent event) {
        //очищаем игровое поле

        for (ButtonClass btnC: buttonArray
             ) {
            btnC.getButton().setText("");
        }

    userPoints.clear();
    compPoints.clear();
    buttonArray.stream()
            .filter(ButtonC -> ButtonC.getButton().equals(ButtonC.getButton(13, 13)))
            .forEach(x -> x.setText("X"));


    //compPoints.add(new Points(13, 13));
    whoseMove = "human";
    }

}
