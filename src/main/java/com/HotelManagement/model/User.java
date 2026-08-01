package com.HotelManagement.model;

public class User{
    String name;
    String address;
    String adhaar;
    int roomAlloted;
    float bill;

    User(String name, String address, String adhaar, int roomAlloted, float bill){
        this.name = name;
        this.address = address;
        this.adhaar = adhaar;
        this.roomAlloted = roomAlloted;
        this.bill = bill;
    }
}