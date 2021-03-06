package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.User;
import com.example.hhsop3rentathing.factory.ProductFactory;
import com.example.hhsop3rentathing.products.RentableProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import static com.example.hhsop3rentathing.HelloApplication.productList;

public class HelloController implements Initializable, Observer {

    private User user;

    @FXML
    private Button logout_btn;

    @FXML
    private TableView<RentableProduct> table_products;

    @FXML
    private TableColumn<RentableProduct, String> prodDescr;

    @FXML
    private TableColumn<RentableProduct, Integer> prodId;

    @FXML
    private TableColumn<RentableProduct, String> prodName;

    @FXML
    private TableColumn<RentableProduct, String> available;

    @FXML
    private Text username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prodId.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodName.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodDescr.setCellValueFactory(new PropertyValueFactory<>("description"));
        available.setCellValueFactory(new PropertyValueFactory<>("Available"));

        table_products.setItems(productList.getProductList());
        table_products.setRowFactory(tv -> {
            TableRow<RentableProduct> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    RentableProduct prod = row.getItem();
                    user.setProductInUse(prod);
                    Stage stage = (Stage) username.getScene().getWindow();
                    stage.setUserData(user);
                    HelloApplication.sceneController.loadScreen("details", stage);
                }
            });
            return row;
        });

        // Observer pattern
        productList.addObserver(this);
    }


    @FXML
    void receiveData() {
        Stage stage = (Stage) username.getScene().getWindow();
        user = (User) stage.getUserData();
        username.setText(user.getUsername());
    }

    @FXML
    void logoutAction(ActionEvent event) {
        LoginController.loggedInUsers.remove(user);
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void addCar(ActionEvent event) {
        Stage stage = (Stage) username.getScene().getWindow();
        user.setProductInUse(ProductFactory.create("car"));
        stage.setUserData(user);
        HelloApplication.sceneController.loadScreen("add", stage);
    }

    @FXML
    void addDrill(ActionEvent event) {
        Stage stage = (Stage) username.getScene().getWindow();
        user.setProductInUse(ProductFactory.create("drill"));
        stage.setUserData(user);
        HelloApplication.sceneController.loadScreen("add", stage);
    }

    @FXML
    void addTruck(ActionEvent event) {
        Stage stage = (Stage) username.getScene().getWindow();
        user.setProductInUse(ProductFactory.create("truck"));
        stage.setUserData(user);
        HelloApplication.sceneController.loadScreen("add", stage);
    }

    @Override
    public void update(Observable o, Object arg) {
        table_products.setItems(productList.getProductList());
    }
}
