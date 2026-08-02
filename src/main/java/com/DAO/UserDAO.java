package com.DAO;

import java.util.List;

import com.HotelManagement.model.User;

public interface UserDAO {
    void addUser(User user);
    User getUserByNameAndPassword(String username, String password);
    User getUserByAdhaar(String adhaar);
    List<User> getAllUsers();
    boolean updateUser(User user);
    void deleteUser(User user);
}

