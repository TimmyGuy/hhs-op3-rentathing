package com.example.hhsop3rentathing.entities;

import com.example.hhsop3rentathing.products.RentableProduct;

public class User {
    private final String username;
    private final String password;
    private RentableProduct productInUse;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RentableProduct getProductInUse() {
        return productInUse;
    }

    public void setProductInUse(RentableProduct productInUse) {
        this.productInUse = productInUse;
    }
}
