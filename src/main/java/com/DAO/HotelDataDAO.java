package com.DAO;

import com.HotelManagement.model.HotelData;

public interface HotelDataDAO {
    void updateTotalBookedRoom(HotelData hotel);
    void updateTotalBookedPartyHall(HotelData hotel);
    void updateTotalBookedMeetingHall(HotelData hotel);
}
