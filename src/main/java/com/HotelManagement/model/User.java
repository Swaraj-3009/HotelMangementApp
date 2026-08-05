package com.HotelManagement.model;

public class User{
    private String name;
    private String password;
    private String address;
    private String adhaar;
    private int roomAlloted;
    private int partyHallAllotedl;
    private int meetingHallAlloted;
    private float bill;

    //getters
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    }
    public String getAdhaar() {
        return adhaar;
    }
    public int getRoomAlloted() {
        return roomAlloted;
    }
    public int getPartyHallAllotedl() {
        return partyHallAllotedl;
    }
    public int getMeetingHallAlloted() {
        return meetingHallAlloted;
    }
    public float getBill() {
        return bill;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }
    public void setRoomAlloted(int roomAlloted) {
        this.roomAlloted = roomAlloted;
    }
    public void setPartyHallAllotedl(int partyHallAllotedl) {
        this.partyHallAllotedl = partyHallAllotedl;
    }
    public void setMeetingHallAlloted(int meetingHallAlloted) {
        this.meetingHallAlloted = meetingHallAlloted;
    }
    public void setBill(float bill) {
        this.bill = bill;
    }
}