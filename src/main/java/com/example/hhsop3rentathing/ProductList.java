package com.example.hhsop3rentathing;

import com.example.hhsop3rentathing.products.Car;
import com.example.hhsop3rentathing.products.Drill;
import com.example.hhsop3rentathing.products.RentableProduct;
import com.example.hhsop3rentathing.products.Truck;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;

public class ProductList extends Observable {
    private ObservableList<RentableProduct> productList = FXCollections.observableArrayList(
            new Car(1, "BMW 116", "Executive sporteditie", "BWM", 800, true),
            new Drill(2, "Makita HP457DWE", "Boor-/schroefmachine", "Makita", "HP457DWE", true),
            new Truck(3, "Volvo FH 500", "2x Tanks/ Leasing", 800, 1200, false),
            new Truck(4, "DAF XF 480", "SC 2x Tanks/ Leasing", 2500, 1600, true),
            new Car(5, "Mercedes X500", "Car goes vroem", "Mercedes", 800, true),
            new Truck(6, "Ford F-Max 500", "New Leasing", 1700, 1200, true),
            new Car(7, "Mercedes X450", "Car goes vroem kaboem", "Mercedes", 800, true),
            new Drill(8, "Powerplus POWX00501", "Accu Boormachine", "Powerplus", "POWX00501", false),
            new Drill(9, "Bosch Boorhamer", "Professional Boorhamer", "Bosch", "GBH 2-26 F", true)
    );

    public ObservableList<RentableProduct> getProductList() {
        return productList;
    }

    public void addProduct(RentableProduct product) {
        productList.add(product);
        setChanged();
        notifyObservers();
    }
}
