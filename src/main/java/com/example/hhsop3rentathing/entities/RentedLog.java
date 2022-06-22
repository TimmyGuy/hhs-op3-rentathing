package com.example.hhsop3rentathing.entities;

import java.util.ArrayList;

public class RentedLog {
    static ArrayList<RentedLog> rentedLogs = new ArrayList<>();

    private int id;
    private final int prodId;
    private final String firstName;
    private final String lastName;
    private final boolean insurance;

    public RentedLog(int id, int prodId, String firstName, String lastName, boolean insurance) {
        this.id = id;
        this.prodId = prodId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.insurance = insurance;
    }

    static public RentedLog getRentedLog(int prodId) {
        for (RentedLog rentedLog : rentedLogs) {
            if (rentedLog.getProdId() == prodId) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getProdId() {
        return prodId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean hasInsurance() {
        return insurance;
    }
}
