package com.HotelManagement;

import com.DAO.Impl.ManagerDaoImpl;
import com.DAO.Impl.UserDaoImpl;

class Verify {
    ManagerDaoImpl managerDAO = new ManagerDaoImpl();
    UserDaoImpl userDAO = new UserDaoImpl();
    
    boolean verifyManager(String username, String password){
        return managerDAO.getManager(username, password) != null;
    }

    boolean isUserExist(String username, String password){
        return userDAO.getUserByNameAndPassword(username, password) != null;
    }
}
