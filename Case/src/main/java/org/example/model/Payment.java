package org.example.model;

public class Payment {
    private int id;
    private int quantity;
    private String name;
    private String phoneNumber;
    private String address;
    private double revenue;




    public Payment(int id, int quantity, double revenue) {
        this.id = id;
        this.quantity = quantity;
        this.revenue = revenue;
    }

    public Payment(int id, int quantity, String name, String phoneNumber, String address, double revenue) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.revenue = revenue;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return id + ";" + quantity + ";" + name + ";" + phoneNumber + ";" + address + ";" + revenue;
    }
}
