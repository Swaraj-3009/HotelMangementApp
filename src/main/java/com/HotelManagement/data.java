package com.HotelManagement;

class Manager{
    private static final String username = "Ram";
    private static final String password = "12345678";

    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }
}

class Employee{
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

class User{
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

class Hotel{
    int totalRoom = 100;
    int totalPartyHall = 3;
    int totalMeetingHall = 10;
    int totalEmployee = 20;
}