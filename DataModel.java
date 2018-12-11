package com.example.gaurav.myapplication;

public class DataModel {

    String name;
    String address;

    public DataModel() {
    }

    public DataModel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
