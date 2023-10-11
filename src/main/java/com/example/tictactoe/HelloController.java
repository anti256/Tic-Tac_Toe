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
        ((Button)event.getSource()).setText("O");

    }

    @FXML
    void initialize(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button btn = new Button();
                btn.setText(String.valueOf(i));
                btn.setAlignment(Pos.CENTER);
                btn.setContentDisplay(ContentDisplay.CENTER);
                btn.setPrefSize(40.0,40.0);
                btn.setMnemonicParsing(false);
                btn.setTextAlignment(TextAlignment.CENTER);
                btn.setFont(Font.font("Arial Narrow", 14.0));
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseevent -> btnClick(new ActionEvent()));
                //btn.setOnAction(btnClick());

                grid.add(btn, i, j);
                //mainWindow.;
                btn.setVisible(true);
            }

        }




    }


}

