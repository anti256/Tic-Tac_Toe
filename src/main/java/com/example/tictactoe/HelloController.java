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
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane mainWindow;

    @FXML
    void btnClick(ActionEvent event) {
        if (((Button)event.getSource()).getText().equals("X")){
       // ((Button)event.getSource()).setFont(Font.);
        ((Button)event.getSource()).setText("O");}
                else ((Button)event.getSource()).setText("X");

    }

    @FXML
    void initialize(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Button btn = new Button();
                //btn.setText(String.valueOf("OOO"));
                btn.setAlignment(Pos.CENTER);
                btn.setContentDisplay(ContentDisplay.CENTER);
                btn.setPrefSize(30.0,30.0);
                btn.setMinSize(30.0, 30.0);
                btn.setMaxSize(30.0, 30.0);
                btn.setMnemonicParsing(false);
                btn.setTextAlignment(TextAlignment.CENTER);
                btn.setFont(Font.font("Arial Narrow", 14.0));
                btn.setOnAction(this::btnClick);
                btn.setText(String.valueOf(i));
                grid.add(btn, i, j);
                //mainWindow.;
                btn.setVisible(true);
            }

        }




    }


}

//btn.setOnAction(new EventHandler<ActionEvent>() {
//
//@Override
//public void handle(ActionEvent event) {
//
//        btn.setText("You've clicked!");
//        }
//        });