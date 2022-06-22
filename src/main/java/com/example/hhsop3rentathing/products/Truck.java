package com.example.hhsop3rentathing.products;

public class Truck extends RentableProduct {
    private int cargoWeight;
    private int weight;

    public Truck() {}

    public Truck(int id, String name, String description, int cargoWeight, int weight, boolean inStorage) {
        super(id, name, description, -1, inStorage);
        this.cargoWeight = cargoWeight;
        this.weight = weight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
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

    @Override
    public double getPricePerDay() {
        return 0.1 * cargoWeight;
    }
}
