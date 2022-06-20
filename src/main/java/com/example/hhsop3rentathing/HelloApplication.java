package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static SceneController sceneController = new SceneController();
    static ProductList productList = new ProductList();

    @Override
    public void start(Stage stage) {
        sceneController.addScreen("dashboard", "hello-view.fxml");
        sceneController.addScreen("login", "login-view.fxml");
        stage.setTitle("Rent A Thing!");
        try {
            stage.setScene(sceneController.activate("login"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}