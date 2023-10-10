package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class HelloController {
    @FXML
    private Label welcomeText;
    private GridPane grid;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void initialize(){
        Button btn = new Button();
        btn.setText("u");
        btn.setAlignment(Pos.CENTER);
        btn.setContentDisplay(ContentDisplay.CENTER);
        btn.setPrefSize(40.0,40.0);
        btn.setMnemonicParsing(false);
        btn.setTextAlignment(TextAlignment.CENTER);

        grid.add(btn);

    }
}

<Button
        GridPane.columnIndex="3">
<font>
<Font name="Arial Narrow" size="14.0" />
</font>
</Button>