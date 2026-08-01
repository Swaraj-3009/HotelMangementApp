package com.DAO;

import com.HotelManagement.model.Manager;

public interface ManagerDAO {
    Manager getManagerByUsername(String username);
}
