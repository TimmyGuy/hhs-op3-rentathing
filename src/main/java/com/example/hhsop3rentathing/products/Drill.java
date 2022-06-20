package com.example.hhsop3rentathing.products;

public class Drill extends RentableProduct {
    private String brand;
    private String type;

    public Drill(int id, String name, String description, String brand, String type, boolean inStorage) {
        super(id, name, description, 5, inStorage);
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getInsurance() {
        return 1;
    }
}
