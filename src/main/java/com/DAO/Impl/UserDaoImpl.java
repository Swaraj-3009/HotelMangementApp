package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.DAO.UserDAO;
import com.HotelManagement.config.DatabaseConnection;
import com.HotelManagement.model.User;

public class UserDaoImpl implements UserDAO{
        
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, password, address, adhaar, roomAlloted, partyHallAlloted, meetingHallAlloted, bill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getAddress());
                ps.setString(4, user.getAdhaar());
                ps.setInt(5, user.getRoomAlloted());
                ps.setInt(6, user.getPartyHallAllotedl());
                ps.setInt(7, user.getMeetingHallAlloted());
                ps.setFloat(8, user.getBill());

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
                        user.setPartyHallAllotedl(rs.getInt("partyHallAlloted"));
                        user.setMeetingHallAlloted(rs.getInt("meetingHallAlloted"));
                        user.setBill(rs.getFloat("bill"));

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
                        user.setPartyHallAllotedl(rs.getInt("partyHallAlloted"));
                        user.setMeetingHallAlloted(rs.getInt("meetingHallAlloted"));
                        user.setBill(rs.getFloat("bill"));

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
        String sql = "UPDATE users SET bill = ? , roomAlloted = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1, user.getBill());
                ps.setInt(2, user.getRoomAlloted());
                ps.setString(3, user.getAdhaar());

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
    public void organiseParty(User user) {
        String sql = "UPDATE users SET bill = ? , partyHallsAlloted = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1, user.getBill());
                ps.setInt(2, user.getPartyHallAllotedl());
                ps.setString(3, user.getAdhaar());

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
        String sql = "UPDATE users SET bill = ? , meetingHallsAlloted = ? WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setFloat(1, user.getBill());
                ps.setInt(2, user.getMeetingHallAlloted());
                ps.setString(3, user.getAdhaar());

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


}
