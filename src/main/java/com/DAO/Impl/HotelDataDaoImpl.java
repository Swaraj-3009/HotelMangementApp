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
        
    }

    @Override
    public void updateTotalBookedPartyHall(HotelData hotel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTotalBookedPartyHall'");
    }

    @Override
    public void updateTotalBookedMeetingHall(HotelData hotel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTotalBookedMeetingHall'");
    }

    @Override
    public HotelData getHotelData() {
        String sql = "Select * FROM hotel";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

                HotelData hotel = new HotelData();
                if(rs.next()){
                    return hotel;
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
