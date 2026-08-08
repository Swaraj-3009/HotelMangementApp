package com.HotelManagement.model;

import java.time.LocalDateTime;

public class User{
    private String name;
    private String password;
    private String address;
    private String adhaar;
    private int roomAlloted;
    private int partyHallAlloted;
    private int meetingHallAlloted;
    private float bill;
    private boolean swimmingPass;
    private boolean playzonePass;
    private boolean gymPass;

    private LocalDateTime roomBookingStart;
    private LocalDateTime roomBookingEnd;
    private LocalDateTime partyHallBookingStart;
    private LocalDateTime partyHallBookingEnd;
    private LocalDateTime meetingHallBookingStart;
    private LocalDateTime meetingHallBookingEnd;

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
    public int getPartyHallAlloted() {
        return partyHallAlloted;
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
    public LocalDateTime getRoomBookingStart() {
        return roomBookingStart;
    }
    public LocalDateTime getPartyHallBookingStart() {
        return partyHallBookingStart;
    }
    public LocalDateTime getMeetingHallBookingStart() {
        return meetingHallBookingStart;
    }
    public LocalDateTime getRoomBookingEnd() {
        return roomBookingEnd;
    }
    public LocalDateTime getPartyHallBookingEnd() {
        return partyHallBookingEnd;
    }
    public LocalDateTime getMeetingHallBookingEnd() {
        return meetingHallBookingEnd;
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
    public void setPartyHallAlloted(int partyHallAlloted) {
        this.partyHallAlloted = partyHallAlloted;
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
    public void setRoomBookingStart(LocalDateTime roomBookingStart) {
        this.roomBookingStart = roomBookingStart;
    }
    public void setPartyHallBookingStart(LocalDateTime partyHallBookingStart) {
        this.partyHallBookingStart = partyHallBookingStart;
    }
    public void setMeetingHallBookingStart(LocalDateTime meetingHallBookingStart) {
        this.meetingHallBookingStart = meetingHallBookingStart;
    }
    public void setRoomBookingEnd(LocalDateTime roomBookingEnd) {
        this.roomBookingEnd = roomBookingEnd;
    }
    public void setPartyHallBookingEnd(LocalDateTime partyHallBookingEnd) {
        this.partyHallBookingEnd = partyHallBookingEnd;
    }
    public void setMeetingHallBookingEnd(LocalDateTime meetingHallBookingEnd) {
        this.meetingHallBookingEnd = meetingHallBookingEnd;
    }
}