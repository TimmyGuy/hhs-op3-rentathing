package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.RentedLog;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    static final SceneController sceneController = new SceneController();
    static ProductList productList;

    public static void main(String[] args) {
        launch();
    }

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
        sceneController.addScreen("add", "add-view.fxml");

        // Load products and logs
        productList = new ProductList();
        RentedLog.addRentedLog(new RentedLog(1, 3, "Tim", "Ohlsen", true));
        RentedLog.addRentedLog(new RentedLog(2, 8, "John", "Doe", false));
    }
}