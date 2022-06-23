package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.User;
import com.example.hhsop3rentathing.products.Car;
import com.example.hhsop3rentathing.products.Drill;
import com.example.hhsop3rentathing.products.RentableProduct;
import com.example.hhsop3rentathing.products.Truck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddController {

    private User user;

    private RentableProduct product = null;

    @FXML
    private Button logout_btn;

    @FXML
    private TextArea prod_descr;

    @FXML
    private TextField prod_info1;

    @FXML
    private TextField prod_info2;

    @FXML
    private TextField prod_name;

    @FXML
    private Text prod_type;

    @FXML
    private Text username;

    @FXML
    void receiveData() {
        Stage stage = (Stage) username.getScene().getWindow();
        user = (User) stage.getUserData();
        username.setText(user.getUsername());

        if (product == null) {
            if(user.getProductInUse() == null) {
                HelloApplication.sceneController.loadScreen("dashboard", stage);
            }
            product = user.getProductInUse();
            setProductInfo(product);
        }
    }

    void setProductInfo(RentableProduct product) {
        if (product instanceof Car) {
            prod_type.setText("Auto");
            prod_info1.setPromptText("Merk");
            prod_info2.setPromptText("Gewicht");
        } else if (product instanceof Truck) {
            prod_type.setText("Vrachtwagen");
            prod_info1.setPromptText("Laadgewicht");
            prod_info2.setPromptText("Gewicht");
        } else if (product instanceof Drill) {
            prod_type.setText("Boormachine");
            prod_info1.setPromptText("Merk");
            prod_info2.setPromptText("Type");
        }
    }


    @FXML
    void addProduct(ActionEvent event) {
        if (product instanceof Car) {
            product.setName(prod_name.getText());
            product.setDescription(prod_descr.getText());
            ((Car) product).setBrand(prod_info1.getText());
            ((Car) product).setWeight(Integer.parseInt(prod_info2.getText()));
        } else if (product instanceof Truck) {
            product.setName(prod_name.getText());
            product.setDescription(prod_descr.getText());
            ((Truck) product).setCargoWeight(Integer.parseInt(prod_info1.getText()));
            ((Truck) product).setWeight(Integer.parseInt(prod_info2.getText()));
        } else if (product instanceof Drill) {
            product.setName(prod_name.getText());
            product.setDescription(prod_descr.getText());
            ((Drill) product).setBrand(prod_info1.getText());
            ((Drill) product).setType(prod_info2.getText());
        }

        product.setInStorage(true);

        HelloApplication.productList.addProduct(product);
        Stage stage = (Stage) username.getScene().getWindow();
        user.setProductInUse(null);
        stage.setUserData(user);
        HelloApplication.sceneController.loadScreen("dashboard", stage);
    }

    @FXML
    void returnToDashboard() {
        Stage stage = (Stage) username.getScene().getWindow();
        user.setProductInUse(null);
        stage.setUserData(user);
        HelloApplication.sceneController.loadScreen("dashboard", stage);
    }

    @FXML
    void logoutAction(ActionEvent event) {
        LoginController.loggedInUsers.remove(user);
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        stage.close();
    }

}
