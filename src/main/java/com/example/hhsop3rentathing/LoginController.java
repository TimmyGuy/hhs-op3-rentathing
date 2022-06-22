package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {
    static ArrayList<User> loggedInUsers = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();
    @FXML
    private Text incorrect_password;
    @FXML
    private Text incorrect_user;
    @FXML
    private Button login_btn;
    @FXML
    private PasswordField passsword_input;
    @FXML
    private TextField username_input;

    public LoginController() {
        users.add(new User("timohlsen", "test123"));
        users.add(new User("admin", "test1234"));
        users.add(new User("johndoe", "test123"));
    }

    @FXML
    void loginUser(ActionEvent event) {
        boolean foundUser = false;
        incorrect_user.setFill(Color.TRANSPARENT);
        incorrect_password.setFill(Color.TRANSPARENT);

        for (User user : users) {
            if (user.getUsername().equals(username_input.getText())) {
                if (user.getPassword().equals(passsword_input.getText())) {
                    foundUser = true;
                    username_input.setText("");
                    passsword_input.setText("");

                    if (loggedInUsers.contains(user)) return;

                    loggedInUsers.add(user);

                    Stage stage = new Stage();
                    stage.setTitle("Rent A Thing Dashboard");
                    stage.show();
                    stage.setUserData(user);
                    HelloApplication.sceneController.loadScreen("dashboard", stage);

                } else {
                    incorrect_password.setFill(Color.RED);
                }
            }
        }
        if (!foundUser) {
            incorrect_user.setFill(Color.RED);
        }
    }

}
