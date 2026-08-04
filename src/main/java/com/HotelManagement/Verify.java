package com.HotelManagement;

import com.DAO.Impl.ManagerDaoImpl;
import com.DAO.Impl.UserDaoImpl;
import com.DAO.UserDAO;
import com.DAO.ManagerDAO;

class Verify {
    ManagerDAO managerDAO = new ManagerDaoImpl();
    UserDAO userDAO = new UserDaoImpl();
    
    boolean verifyManager(String username, String password){
        return managerDAO.getManager(username, password) != null;
    }

    boolean isUserExist(String username, String password){
        return userDAO.getUserByNameAndPassword(username, password) != null;
    }

    boolean isUserExistByAdhaar(String adhaar){
        return userDAO.getUserByAdhaar(adhaar) != null;
    }

    //boolean isRoomAvailabale(Room room){
    //     return false;
    //}
}
