package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import com.DAO.UserDAO;
import com.HotelManagement.config.DatabaseConnection;
import com.HotelManagement.model.User;

public class UserDaoImpl implements UserDAO{
        
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO user (name, address, adhaar, roomAlloted, bill) VALUES (?, ?, ?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getName());
                ps.setString(2, user.getAddress());
                ps.setString(3, user.getAdhaar());
                ps.setInt(4, user.getRoomAlloted());
                ps.setFloat(5, user.getBill());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public User getUserByAdhaar(String adhaar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByAdhaar'");
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public boolean updateUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(User user) {
        String sql = "UPDATE user Where adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getAdhaar());
                ps.executeUpdate();
                
                System.out.println("User removed successfully");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
