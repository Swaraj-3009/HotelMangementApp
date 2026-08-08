package com.HotelManagement.model;

public class Employee{
    private String name;
    private String address;
    private String adhaar;
    private String password;
    private String designation;
    private float salary;

    //getters
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getAdhaar() {
        return adhaar;
    }
    public String getPassword() {
        return password;
    }
    public String getDesignation() {
        return designation;
    }
    public float getSalary() {
        return salary;
    }
    
    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
