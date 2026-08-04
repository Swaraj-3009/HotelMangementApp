package com.DAO;

import com.HotelManagement.model.HotelData;

public interface HotelDataDAO {
    HotelData getHotelData();
    void updateTotalBookedRoom(HotelData hotel);
    void updateTotalBookedPartyHall(HotelData hotel);
    void updateTotalBookedMeetingHall(HotelData hotel);
}
