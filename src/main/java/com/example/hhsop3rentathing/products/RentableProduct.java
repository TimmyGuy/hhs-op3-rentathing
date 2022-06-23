package com.example.hhsop3rentathing.products;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class RentableProduct {
    protected SimpleIntegerProperty id;
    protected SimpleStringProperty name;
    protected SimpleStringProperty description;
    protected int pricePerDay;
    protected boolean inStorage;

    public RentableProduct() {
    }

    public RentableProduct(int id, String name, String description, int pricePerDay, boolean inStorage) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.pricePerDay = pricePerDay;
        this.inStorage = inStorage;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public double getPrice(boolean withInsurance) {
        double fullPrice = getPricePerDay();

        if(withInsurance) {
            fullPrice += getInsurance();
        }

        return fullPrice;
    }

    public abstract double getInsurance();

    public void setInStorage(boolean inStorage) {
        this.inStorage = inStorage;
    }

    public String getAvailable() {
        return inStorage ? "Ja" : "Nee";
    }

    public boolean isAvailable() {
        return !inStorage;
    }

}
