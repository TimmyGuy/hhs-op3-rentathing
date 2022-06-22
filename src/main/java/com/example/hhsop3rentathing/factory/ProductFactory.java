package com.example.hhsop3rentathing.factory;

import com.example.hhsop3rentathing.products.Car;
import com.example.hhsop3rentathing.products.Drill;
import com.example.hhsop3rentathing.products.RentableProduct;
import com.example.hhsop3rentathing.products.Truck;

import java.util.Locale;

public class ProductFactory {
    final static String CAR = "car";
    final static String TRUCK = "truck";
    final static String DRILL = "drill";

    public static RentableProduct create(String prodType) {
        switch (prodType.toLowerCase(Locale.ROOT)) {
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            case DRILL:
                return new Drill();
        }
        System.out.println("Product not found! Try again");
        return null;
    }
}
