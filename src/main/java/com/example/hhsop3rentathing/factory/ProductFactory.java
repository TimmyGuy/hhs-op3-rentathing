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

    public static RentableProduct create(String prodType) throws Exception {
        switch (prodType.toLowerCase(Locale.ROOT)) {
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            case DRILL:
                return new Drill();
        }
        throw new Exception("No product found with this product type");
    }
}
