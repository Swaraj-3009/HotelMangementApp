package com.HotelManagement.model;

public class HotelData {
    public static final int totalRoom = 100;
    public static final int totalPartyHall = 3;
    public static final int totalMeetingHall = 10;
    public static final int totalEmployee = 20;

    private int totalBookedRoom;
    private int totalBookedPartyHall;
    private int totalBookedMeetingHall;
    
    //getters
    public int getTotalBookedRoom() {
        return totalBookedRoom;
    }
    public int getTotalBookedPartyHall() {
        return totalBookedPartyHall;
    }
    public int getTotalBookedMeetingHall() {
        return totalBookedMeetingHall;
    }

    //setters
    public void setTotalBookedRoom(int totalBookedRoom) {
        this.totalBookedRoom = totalBookedRoom;
    }
    public void setTotalBookedPartyHall(int totalBookedPartyHall) {
        this.totalBookedPartyHall = totalBookedPartyHall;
    }
    public void setTotalBookedMeetingHall(int totalBookedMeetingHall) {
        this.totalBookedMeetingHall = totalBookedMeetingHall;
    }

    
}
