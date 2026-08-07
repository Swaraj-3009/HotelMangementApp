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
    private boolean swimmingPass;
    private boolean playzonePass;
    private boolean gymPass;

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
    public boolean getSwimmingPass(){
        return swimmingPass;
    }
    public boolean getPlayZonePass(){
        return playzonePass;
    }
    public boolean getGymPass(){
        return gymPass;
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
    public void setSwimmingPass(boolean swimmingPass) {
        this.swimmingPass = swimmingPass;
    }
    public void setPlayzonePass(boolean playzonePass) {
        this.playzonePass = playzonePass;
    }
    public void setGymPass(boolean gymPass) {
        this.gymPass = gymPass;
    }
}