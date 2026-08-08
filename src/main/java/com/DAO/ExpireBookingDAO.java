package com.DAO;

public interface ExpireBookingDAO {
       void expireRoomBookings();
       void expirePartyHallBookings();
       void expireMeetingHallBookings();
}
