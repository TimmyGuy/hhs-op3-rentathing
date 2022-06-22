package com.example.hhsop3rentathing.entities;

import com.example.hhsop3rentathing.products.RentableProduct;

import java.util.ArrayList;

public class RentedLog {
    static ArrayList<RentedLog> rentedLogs = new ArrayList<>();

    private int id;
    private int prodId;
    private String firstName;
    private String lastName;
    private boolean insurance;

    public RentedLog(int id, int prodId, String firstName, String lastName, boolean insurance) {
        this.id = id;
        this.prodId = prodId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.insurance = insurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean hasInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    static public RentedLog getRentedLog(int prodId) {
        for(RentedLog rentedLog : rentedLogs) {
            if(rentedLog.getProdId() == prodId) {
                return rentedLog;
            }
        }
        return null;
    }

    static public void addRentedLog(RentedLog log) {
        log.setId(1);
        rentedLogs.add(log);
    }

    static public void removeRentedLog(RentedLog log) {
        rentedLogs.remove(log);
    }
}
