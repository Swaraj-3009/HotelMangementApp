package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.DAO.UserDAO;
import com.HotelManagement.config.DatabaseConnection;
import com.HotelManagement.model.User;

public class UserDaoImpl implements UserDAO{
        
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, password, address, adhaar, roomAlloted, roomBookingStart, roomBookingEnd, partyHallAlloted, partyHallBookingStart, partyHallBookingEnd, meetingHallAlloted, meetingHallBookingStart, meetingHallBookingEnd, bill, swimmingPass, playzonePass, gymPass) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getAddress());
                ps.setString(4, user.getAdhaar());
                ps.setInt(5, user.getRoomAlloted());
                ps.setTimestamp(6, toTimestamp(user.getRoomBookingStart()));
                ps.setTimestamp(7, toTimestamp(user.getRoomBookingEnd()));
                ps.setInt(8, user.getPartyHallAlloted());
                ps.setTimestamp(9, toTimestamp(user.getPartyHallBookingStart()));
                ps.setTimestamp(10, toTimestamp(user.getPartyHallBookingEnd()));
                ps.setInt(11, user.getMeetingHallAlloted());
                ps.setTimestamp(12, toTimestamp(user.getMeetingHallBookingStart()));
                ps.setTimestamp(13, toTimestamp(user.getMeetingHallBookingEnd()));
                ps.setFloat(14, user.getBill());
                ps.setBoolean(15, user.getSwimmingPass());
                ps.setBoolean(16, user.getPlayZonePass());
                ps.setBoolean(17, user.getGymPass());

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("User added successfully");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, username);
                ps.setString(2, password);
                try(ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        User user = new User();

                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));
                        user.setAddress(rs.getString("address"));
                        user.setAdhaar(rs.getString("adhaar"));
                        user.setRoomAlloted(rs.getInt("roomAlloted"));
                        user.setPartyHallAlloted(rs.getInt("partyHallAlloted"));
                        user.setMeetingHallAlloted(rs.getInt("meetingHallAlloted"));
                        user.setBill(rs.getFloat("bill"));
                        user.setSwimmingPass(rs.getBoolean("swimmingPass"));
                        user.setPlayzonePass(rs.getBoolean("playzonePass"));
                        user.setGymPass(rs.getBoolean("gymPass"));

                        return user;
                    }
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    private Timestamp toTimestamp(java.time.LocalDateTime dateTime) {
        return dateTime == null ? null : Timestamp.valueOf(dateTime);
    }
        

    @Override
    public User getUserByAdhaar(String adhaar) {
        String sql = "SELECT * FROM users WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, adhaar);

                try(ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {

                        User user = new User();

                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));
                        user.setAddress(rs.getString("address"));
                        user.setAdhaar(rs.getString("adhaar"));
                        user.setRoomAlloted(rs.getInt("roomAlloted"));
                        user.setPartyHallAlloted(rs.getInt("partyHallAlloted"));
                        user.setMeetingHallAlloted(rs.getInt("meetingHallAlloted"));
                        user.setBill(rs.getFloat("bill"));
                        user.setSwimmingPass(rs.getBoolean("swimmingPass"));
                        user.setPlayzonePass(rs.getBoolean("playzonePass"));
                        user.setGymPass(rs.getBoolean("gymPass"));

                        return user;
                    }
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

                while(rs.next()){
                    User user = new User();
                    user.setName(rs.getString("name"));
                    user.setAddress(rs.getString("address"));
                    user.setAdhaar(rs.getString("adhaar"));

                    users.add(user);
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUserProfile(User user) {
        String sql = "UPDATE users SET name = ? , address = ? , password = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getName());
                ps.setString(2, user.getAddress());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getAdhaar());

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("User Profile Updated successfully");
                }
                else {
                    System.out.println("User not found");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getAdhaar());

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("User removed successfully");
                }
                else {
                    System.out.println("User not found");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void bookRoom(User user){
        String sql = "UPDATE users SET bill = ? , roomAlloted = ?, roomBookingStart = ?, roomBookingEnd = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1, user.getBill());
                ps.setInt(2, user.getRoomAlloted());
                ps.setTimestamp(3, Timestamp.valueOf(user.getRoomBookingStart()));
                ps.setTimestamp(4, Timestamp.valueOf(user.getRoomBookingEnd()));
                ps.setString(5, user.getAdhaar());

                int rows = ps.executeUpdate();

                if(rows > 0){
                    System.out.println("Room Booked");
                }
                else{
                    System.out.println("Sorry try again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void orderfood(User user){
        String sql = " UPDATE users SET bill = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1,  user.getBill());
                ps.setString(2, user.getAdhaar());

                int rows = ps.executeUpdate();

                if(rows > 0){
                    System.out.println("Food ordered");
                }
                else{
                    System.out.println("Sorry try again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void organiseParty(User user) {
        String sql = "UPDATE users SET bill = ?, partyHallAlloted = ?, partyHallBookingStart = ?, partyHallBookingEnd = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1, user.getBill());
                ps.setInt(2, user.getPartyHallAlloted());
                ps.setTimestamp(3, Timestamp.valueOf(user.getPartyHallBookingStart()));
                ps.setTimestamp(4, Timestamp.valueOf(user.getPartyHallBookingEnd()));
                ps.setString(5, user.getAdhaar());

                int rows = ps.executeUpdate();
                if(rows > 0){
                    System.out.println("Party Hall Booked");
                }
                else{
                    System.out.println("Try Again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void bookMeetingHall(User user) {
        String sql = "UPDATE users SET bill = ?, meetingHallAlloted = ?, meetingHallBookingStart = ?, meetingHallBookingEnd = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1, user.getBill());
                ps.setInt(2, user.getMeetingHallAlloted());
                ps.setTimestamp(3, Timestamp.valueOf(user.getMeetingHallBookingStart()));
                ps.setTimestamp(4, Timestamp.valueOf(user.getMeetingHallBookingEnd()));
                ps.setString(5, user.getAdhaar());

                int rows = ps.executeUpdate();
                if(rows > 0){
                    System.out.println("Meeting Hall Booked");
                }
                else{
                    System.out.println("Try Again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void takeSwimmingPass(User user) {
        String sql = "UPDATE users SET swimmingPass = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setBoolean(1, true);
                ps.setString(2, user.getAdhaar());

                int rows = ps.executeUpdate();
                if(rows > 0){
                    System.out.println("Congratulations, Now you are Fish");
                }
                else{
                    System.out.println("Try Again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void takePlayzonePass(User user) {
        String sql = "UPDATE users SET playzonePass = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setBoolean(1, true);
                ps.setString(2, user.getAdhaar());

                int rows = ps.executeUpdate();
                if(rows > 0){
                    System.out.println("Congratulations, Now you are Sportsman");
                }
                else{
                    System.out.println("Try Again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void takeGymPass(User user) {
        String sql = "UPDATE users SET gymPass = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setBoolean(1, true);
                ps.setString(2, user.getAdhaar());

                int rows = ps.executeUpdate();
                if(rows > 0){
                    System.out.println("Congratulations, Now you are Athelete");
                }
                else{
                    System.out.println("Try Again");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
