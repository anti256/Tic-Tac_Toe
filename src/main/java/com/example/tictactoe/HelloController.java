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
    ArrayList<ButtonClass> buttonArray = new ArrayList<>();
    @FXML
    ArrayList<ButtonClass> compPoints = new ArrayList<>();//клетки компьютера
    @FXML
    ArrayList<ButtonClass> userPoints = new ArrayList<>();//клетки человека

    //HashMap<Integer, Integer> compPoints = new HashMap<>();
    //HashMap<Integer, Integer> userPoints = new HashMap<>();
    //ArrayList<Points> userPoints = new ArrayList<>();
    String whoseMove;

    @FXML
    void btnClick(ActionEvent event) {
        /*if (whoseMove.equals("human")) {
            ((Button)event.getSource()).
            if (compPoints.contains())
        }*/
        Button btnEvent = (Button)event.getSource();
        //System.out.println(btnEvent.toString());
        //buttonArray.stream().filter(x->x.getButton().equals(btnEvent)).forEach(x-> System.out.println(x.getButton()));
        ButtonClass bc = buttonClassByButton(btnEvent);
                //buttonArray.get(buttonArray.indexOf(btnEvent));
        bc.getButton().setText(Integer.toString(bc.getX(bc.getButton())));
        //((Button)event.getSource()).setText("O");

        /*if (((Button)event.getSource()).getText().equals("X")){
            ((Button)event.getSource()).setText("O");
       ((Button)event.getSource()).setStyle("-fx-text-fill: #ff0000");}
                else {((Button)event.getSource()).setText("X");
            ((Button)event.getSource()).setStyle("-fx-text-fill: #0000ff");}*/

    }

    @FXML
    void initialize(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Button button = new Button(" ");
//                button.setAlignment(Pos.CENTER);
//                button.setContentDisplay(ContentDisplay.CENTER);
//                button.setPrefSize(30.0,30.0);
//                button.setMinSize(30.0, 30.0);
//                button.setMaxSize(30.0, 30.0);
//                button.setMnemonicParsing(false);
//                button.setTextAlignment(TextAlignment.CENTER);
//                button.setFont(Font.font("Arial Narrow", 14.0));
                button.setOnAction(this::btnClick);
                grid.add(button, i, j);
                //button.setVisible(true);
                ButtonClass btnCl = new ButtonClass(button, i, j);
                buttonArray.add(btnCl);
                //btnCl.getButton(i, j).setVisible(true);
            }
        }
        //grid.setVisible(true);
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
    buttonArray.get(0).getButton().setVisible(true);
    buttonArray.get(0).setText("sdf");
    }

    ButtonClass buttonClassByButton (Button btn){
        for (ButtonClass bc: buttonArray
             ) {
            if (bc.getButton().equals(btn)) {return bc;}
        }
        return  null;
    }

}
