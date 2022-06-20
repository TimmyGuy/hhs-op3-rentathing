package com.example.hhsop3rentathing.entities;

import com.example.hhsop3rentathing.products.RentableProduct;

public class User {
    private String username;
    private String password;
    private RentableProduct productInUse;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RentableProduct getProductInUse() {
        return productInUse;
    }

    public void setProductInUse(RentableProduct productInUse) {
        this.productInUse = productInUse;
    }
}
