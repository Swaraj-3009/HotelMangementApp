package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.DAO.ManagerDAO;
import com.HotelManagement.config.DatabaseConnection;
import com.HotelManagement.model.Manager;

public class ManagerDaoImpl implements ManagerDAO{
    @Override
    public Manager getManager(String username, String password){
        String sql = "SELECT * FROM manager WHERE username = ? AND password = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

                ps.setString(1, username);
                ps.setString(2, password);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Manager manage = new Manager();
                    manage.setPassword(rs.getString("password"));
                    manage.setUsername(rs.getString("username"));

                    return manage;
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
