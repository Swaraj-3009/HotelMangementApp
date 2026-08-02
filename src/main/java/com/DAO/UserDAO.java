package com.DAO;

import java.util.List;

import com.HotelManagement.model.User;

public interface UserDAO {
    void addUser(User user);
    User getUserById(int id);
    User getUserByAdhaar(String adhaar);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(int id);
}

