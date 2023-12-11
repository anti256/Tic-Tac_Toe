package com.example.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ButtonClass {
    Button button;
    private int x;
    private int y;


    public ButtonClass(Button button, int x, int y) {
        this.button = button;
        button.setAlignment(Pos.CENTER);
        button.setContentDisplay(ContentDisplay.CENTER);
        button.setPrefSize(30.0,30.0);
        button.setMinSize(30.0, 30.0);
        button.setMaxSize(30.0, 30.0);
        button.setMnemonicParsing(false);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setFont(Font.font("Arial Narrow", 14.0));
        button.setOnAction(HelloController::btnClick);
        this.x = x;
        this.y = y;
        button.setVisible(true);
    }

    public Button getButton (){
        return button;
    }

    public Button getButton(int xg, int yg){
        if (xg == x && yg == y ) {return button;}
        return null;
    }

    public void setText (String str){
        button.setText(str);
    }

    public String getText (Button btn){
        return btn.getText();
    }

    public int getX (Button btn){
        return x;
    }

    public int getY (Button btn){
        return y;
    }

}
//if (((Button)event.getSource()).getText().equals("X")){
//            ((Button)event.getSource()).setText("O");