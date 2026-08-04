package com.DAO;

import java.util.List;

import com.HotelManagement.model.User;

public interface UserDAO {
    void addUser(User user);
    User getUserByNameAndPassword(String username, String password);
    User getUserByAdhaar(String adhaar);
    List<User> getAllUsers();
    void updateUserProfile(User user);
    void deleteUser(User user);
    void updateBill(User user);
    void updateRoomAllocation(User user);
}

