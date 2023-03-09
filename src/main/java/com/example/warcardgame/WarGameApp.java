/* =============================================================

Author : Nikell Reed
Class : ITN262
Class Section : 4C1
Date : 3/21/2022
Assignment : Card Game

================================================================*/

package com.example.warcardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WarGameApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WarGameApp.class.getResource("cardgame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 970, 600);
        stage.setTitle("War Card Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}