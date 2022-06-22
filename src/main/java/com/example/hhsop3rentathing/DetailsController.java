package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.entities.RentedLog;
import com.example.hhsop3rentathing.entities.User;
import com.example.hhsop3rentathing.products.Car;
import com.example.hhsop3rentathing.products.Drill;
import com.example.hhsop3rentathing.products.RentableProduct;
import com.example.hhsop3rentathing.products.Truck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import static com.example.hhsop3rentathing.HelloApplication.productList;

public class DetailsController implements Observer, Initializable {
    private User user;

    private RentableProduct product = null;

    @FXML
    private TextField first_name;

    @FXML
    private CheckBox insurance_checkbox;

    @FXML
    private TextField last_name;

    @FXML
    private Button logout_btn;

    @FXML
    private Text price_text;

    @FXML
    private TextArea prod_descr;

    @FXML
    private TextField prod_info1;

    @FXML
    private TextField prod_info2;

    @FXML
    private TextField prod_name;

    @FXML
    private Button return_btn;

    @FXML
    private Text show_price_text;

    @FXML
    private Button retour_btn;

    @FXML
    private Text username;

    @Override
    public void update(Observable o, Object arg) {
        product = productList.getProduct(product.getId());
        setProductInfo(product);
    }

    @FXML
    void receiveData() {
        Stage stage = (Stage) username.getScene().getWindow();
        user = (User) stage.getUserData();
        username.setText(user.getUsername());

        if(product == null) {
            product = user.getProductInUse();
            setProductInfo(product);
        }
    }

    void setProductInfo (RentableProduct product) {
        prod_name.setText(product.getName());
        prod_descr.setText(product.getDescription());

        price_text.setText(String.format("%.2f", product.getPricePerDay()));

        if(product instanceof Car) {
            prod_info1.setText(((Car) product).getBrand());
            prod_info2.setText(((Car) product).getWeight() + "kg gewicht");
        } else if (product instanceof Drill) {
            prod_info1.setText(((Drill) product).getBrand());
            prod_info2.setText(((Drill) product).getType());
        } else if (product instanceof Truck) {
            prod_info1.setText(((Truck) product).getCargoWeight() + "kg vervoer");
            prod_info2.setText(((Truck) product).getWeight() + "kg gewicht");
        }

        retour_btn.setText("Verhuur");

        if(product.getAvailable().equals("Nee")) {
            RentedLog log = RentedLog.getRentedLog(product.getId());
            first_name.setText(log.getFirstName());
            first_name.setEditable(false);
            last_name.setText(log.getLastName());
            last_name.setEditable(false);
            retour_btn.setText("Retour");
            insurance_checkbox.setVisible(false);
            if(log.hasInsurance()) {
                price_text.setText(String.format("%.2f", product.getPricePerDay() + product.getInsurance()));
            }
        } else {
            first_name.setEditable(true);
            last_name.setEditable(true);
            first_name.setText("");
            last_name.setText("");
            insurance_checkbox.setVisible(true);
        }
    }

    @FXML
    void handleRetour(ActionEvent event) {
        if(product.isAvailable()) {
            RentedLog log = RentedLog.getRentedLog(product.getId());
            RentedLog.removeRentedLog(log);
            product.setInStorage(true);
            productList.updateProduct(product.getId(), product);
        } else {
            RentedLog log = new RentedLog(-1, product.getId(), first_name.getText(), last_name.getText(), insurance_checkbox.isSelected());
            RentedLog.addRentedLog(log);
            product.setInStorage(false);
            productList.updateProduct(product.getId(), product);
        }
    }

    @FXML
    void adjustInsurance(ActionEvent event) {
        if (insurance_checkbox.isSelected()) {
            price_text.setText(String.format("%.2f", product.getPricePerDay() + product.getInsurance()));
        } else {
            price_text.setText(String.format("%.2f", product.getPricePerDay()));
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Observer pattern
        productList.addObserver(this);
    }
}
