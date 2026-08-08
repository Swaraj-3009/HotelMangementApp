package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.DAO.ExpireBookingDAO;
import com.HotelManagement.config.DatabaseConnection;

public class ExpireBookingDaoImpl implements ExpireBookingDAO{
    @Override
    public void expireRoomBookings() {
        String sql1 = "SELECT * FROM users WHERE roomBookingEnd IS NOT NULL AND roomBookingEnd <= NOW()";
        String sql2 = "UPDATE users SET roomAlloted = ? , roomBookingStart = ? , roomBookingEnd = ? WHERE roomBookingEnd IS NOT NULL AND roomBookingEnd <= NOW()";

        int expiredRooms = 0;

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs = ps1.executeQuery()){
                
                while(rs.next()){
                    String adhaar = rs.getString("adhaar");
                    int rooms = rs.getInt("roomAlloted");
                    expiredRooms += rooms;
                    System.out.println("Booking expired for: " + adhaar + " | Rooms released: " + rooms);
                }

                ps2.setInt(1, 0);
                ps2.setTimestamp(2, null);
                ps2.setTimestamp(3, null);

                int rows = ps2.executeUpdate();
                if(rows > 0){
                    System.out.println("Booking Expired");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(expiredRooms > 0){
            String sql = "UPDATE hotel SET TotalBookedRoom = TotalBookedRoom - ? WHERE id = 1";

            try(Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, expiredRooms);

                ps.executeUpdate();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void expirePartyHallBookings() {
        String sql1 = "SELECT * FROM users WHERE partyHallBookingEnd IS NOT NULL AND partyHallBookingEnd <= NOW()";
        String sql2 = "UPDATE users SET partyHallAlloted = ? , partyHallBookingStart = ? , partyHallBookingEnd = ? WHERE partyHallBookingEnd IS NOT NULL AND partyHallBookingEnd <= NOW()";

        int expiredPartyHalls = 0;

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs = ps1.executeQuery()){
                while(rs.next()){
                    String adhaar = rs.getString("adhaar");
                    int partyHalls = rs.getInt("roomAlloted");
                    expiredPartyHalls += partyHalls;
                    System.out.println("Booking expired for: " + adhaar + " | Rooms released: " + partyHalls);
                }

                ps2.setInt(1, 0);
                ps2.setTimestamp(2, null);
                ps2.setTimestamp(3, null);

                int rows = ps2.executeUpdate();
                if(rows > 0){
                    System.out.println("Booking Expired");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(expiredPartyHalls > 0){
            String sql = "UPDATE hotel SET TotalBookedPartyHalls = TotalBookedPartyHalls - ? WHERE id = 1";

            try(Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, expiredPartyHalls);

                ps.executeUpdate();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void expireMeetingHallBookings() {
        String sql1 = "SELECT * FROM users WHERE meetingHallBookingEnd IS NOT NULL AND meetingHallBookingEnd <= NOW()";
        String sql2 = "UPDATE users SET meetingHallAlloted = ? , meetingHallBookingStart = ? , meetingHallBookingEnd = ? WHERE meetingHallBookingEnd IS NOT NULL AND meetingHallBookingEnd <= NOW()";

        int expiredMeetingHalls = 0;

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs = ps1.executeQuery()){
                while(rs.next()){
                    String adhaar = rs.getString("adhaar");
                    int meetingHalls = rs.getInt("roomAlloted");
                    expiredMeetingHalls += meetingHalls;
                    System.out.println("Booking expired for: " + adhaar + " | meetingHalls released: " + meetingHalls);
                }

                ps2.setInt(1, 0);
                ps2.setTimestamp(2, null);
                ps2.setTimestamp(3, null);

                int rows = ps2.executeUpdate();
                if(rows > 0){
                    System.out.println("Booking Expired");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(expiredMeetingHalls > 0){
            String sql = "UPDATE hotel SET TotalBookedMeetingHalls = TotalBookedMeetingHalls - ? WHERE id = 1";

            try(Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, expiredMeetingHalls);

                ps.executeUpdate();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
