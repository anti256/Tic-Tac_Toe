package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Крестики-нолики");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

//alignment="CENTER" contentDisplay="CENTER" mnemonicParsing="false" prefHeight="23.0" prefWidth="40.0" text="X" textAlignment="CENTER" GridPane.columnIndex="3">
//               <font>
//                  <Font name="Arial Narrow" size="14.0" />
//               </font>