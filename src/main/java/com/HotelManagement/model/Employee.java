package com.HotelManagement.model;

public class Employee{
    String name;
    String address;
    String adhaar;
    String password;
    String designation;
    float salary;

    Employee(String name, String address, String adhaar, String password, String designation, float salary){
        this.name = name;
        this.address = address;
        this.adhaar = adhaar;
        this.password = password;
        this.designation = designation;
        this.salary = salary;
    }
}
