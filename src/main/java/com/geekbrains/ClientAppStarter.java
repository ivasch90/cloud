package com.geekbrains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientAppStarter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("clientApp.fxml"));
        primaryStage.setTitle("Client App Cloud");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
