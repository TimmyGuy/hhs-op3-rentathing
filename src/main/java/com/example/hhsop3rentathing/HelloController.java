package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.User;
import com.example.hhsop3rentathing.products.Car;
import com.example.hhsop3rentathing.products.RentableProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
    void addTestItem(ActionEvent event) {
        productList.addProduct(new Car(88, "test", "test", "test", 8, true));
    }

    @Override
    public void update(Observable o, Object arg) {
        table_products.setItems(productList.getProductList());
    }
}
