package com.DAO;

import com.HotelManagement.model.Manager;

public interface ManagerDAO {
    Manager getManager(String username, String password) throws Exception;
}
