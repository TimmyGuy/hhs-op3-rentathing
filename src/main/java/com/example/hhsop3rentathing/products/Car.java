package com.example.hhsop3rentathing.products;

public class Car extends RentableProduct {
    private String brand;
    private int weight;

    public Car() {}

    public Car(int id, String name, String description, String brand, int weight, boolean inStorage) {
        super(id, name, description, 50, inStorage);
        this.brand = brand;
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public double getInsurance() {
        return 0.01 * weight;
    }
}
