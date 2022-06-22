package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.RentedLog;
import com.example.hhsop3rentathing.entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static SceneController sceneController = new SceneController();
    static ProductList productList;

    @Override
    public void start(Stage stage) {
        loader();
        stage.setTitle("Rent A Thing!");
        try {
            stage.setScene(sceneController.activate("login"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stage.show();
    }

    public void loader() {
        // Load the screens
        sceneController.addScreen("dashboard", "hello-view.fxml");
        sceneController.addScreen("login", "login-view.fxml");
        sceneController.addScreen("details", "details-view.fxml");

        // Load products and logs
        productList = new ProductList();
        RentedLog.addRentedLog(new RentedLog(1, 3, "Tim", "Ohlsen", true));
        RentedLog.addRentedLog(new RentedLog(2, 8, "John", "Doe", false));
    }

    public static void main(String[] args) {
        launch();
    }
}