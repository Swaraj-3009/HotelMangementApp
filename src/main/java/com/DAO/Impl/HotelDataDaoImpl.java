package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DAO.HotelDataDAO;
import com.HotelManagement.config.DatabaseConnection;
import com.HotelManagement.model.HotelData;

public class HotelDataDaoImpl implements HotelDataDAO{

    @Override
    public void updateTotalBookedRoom(HotelData hotel) {
        String sql = "Update hotel SET TotalBookedRoom = ? WHERE id = 1";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1, hotel.getTotalBookedRoom());
                ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTotalBookedPartyHall(HotelData hotel) {
        String sql = "Update hotel SET TotalBookedPartyHall = ? WHERE id = 1";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1, hotel.getTotalBookedPartyHall());
                ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTotalBookedMeetingHall(HotelData hotel) {
        String sql = "Update hotel SET TotalBookedMeetingHall = ? WHERE id = 1";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1, hotel.getTotalBookedMeetingHall());
                ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public HotelData getHotelData() {
        String sql = "Select * FROM hotel WHERE id = 1";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

                HotelData hotel = new HotelData();
                if(rs.next()){
                    hotel.setTotalBookedRoom(rs.getInt("TotalBookedRoom"));
                    hotel.setTotalBookedPartyHall(rs.getInt("TotalBookedPartyHall"));
                    hotel.setTotalBookedMeetingHall(rs.getInt("TotalBookedMeetingHall"));
                    return hotel;
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
