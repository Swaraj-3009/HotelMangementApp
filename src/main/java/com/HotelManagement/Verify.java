package com.HotelManagement;

import com.DAO.Impl.ManagerDaoImpl;
import com.DAO.Impl.UserDaoImpl;
import com.DAO.Impl.EmployeeDaoImpl;
import com.DAO.Impl.HotelDataDaoImpl;
import com.DAO.UserDAO;
import com.DAO.ManagerDAO;
import com.DAO.HotelDataDAO;
import com.DAO.EmployeeDAO;

class Verify {
    ManagerDAO managerDAO = new ManagerDaoImpl();
    UserDAO userDAO = new UserDaoImpl();
    HotelDataDAO hotelDAO = new HotelDataDaoImpl();
    EmployeeDAO employeeDAO = new EmployeeDaoImpl();
    
    boolean verifyManager(String username, String password){
        return managerDAO.getManager(username, password) != null;
    }

    boolean isUserExist(String username, String password){
        return userDAO.getUserByNameAndPassword(username, password) != null;
    }

    boolean isUserExistByAdhaar(String adhaar){
        return userDAO.getUserByAdhaar(adhaar) != null;
    }

    boolean isEmployeeExist(String adhaar){
        return employeeDAO.getEmployee(adhaar) != null;
    }

    boolean isRoomAvailabale(int totalRoomToBeBooked){
        return (100 - hotelDAO.getHotelData().getTotalBookedRoom()) >= totalRoomToBeBooked;
    }

    boolean isMeetingHallAvailable(int totalMeetingHallToBeBooked){
        return(10 - hotelDAO.getHotelData().getTotalBookedMeetingHall() >= totalMeetingHallToBeBooked);
    }

    boolean isPartyHallAvailable(int totalPartyHallToBeBooked){
        return(3 - hotelDAO.getHotelData().getTotalBookedPartyHall() >= totalPartyHallToBeBooked);
    }
}
