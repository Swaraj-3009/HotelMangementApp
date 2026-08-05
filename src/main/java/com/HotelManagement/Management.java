package com.HotelManagement;

import java.util.List;
import java.util.Scanner;
import com.DAO.HotelDataDAO;
import com.DAO.Impl.HotelDataDaoImpl;
import com.DAO.UserDAO;
import com.DAO.Impl.UserDaoImpl;
import com.HotelManagement.model.HotelData;
import com.HotelManagement.model.User;

class ManagerManagement{
   UserDAO userDao = new UserDaoImpl();
   
   void addEmployee(){

   }

   void removeEmployee(){

   }

   void checkBookedRoom(){

   }

   void checkUnbookedRoom(){

   }

   void totalEmployee(){

   }

   void totalUser(){
      List<User> u = userDao.getAllUsers();

      for(int i = 0; i<= u.size()-1 ; i++){
         System.out.println("| S.no : " + i + " | Name : " + u.get(i).getName() + " | Adhaar : " + u.get(i).getAdhaar() + " | Address : " + u.get(i).getAddress());
      }
   }

   void getUserByAdhaar(String adhaar){
      User u = userDao.getUserByAdhaar(adhaar);
      
      if(u == null){
        System.out.println("User not found");
        return;
      }

      System.out.println("Name : " + u.getName());
      System.out.println("Adhaar : " + u.getAdhaar());
      System.out.println("Address : " + u.getAddress());
      System.out.println("Room Alloted : " + u.getRoomAlloted());
      System.out.println("Bill : " + u.getBill());
   }
}

class BothAccessed{
   UserDAO userDao = new UserDaoImpl();

   void addUser(String username, String password, Scanner sc){
      User user = new User();
      user.setName(username);
      user.setPassword(password);

      System.out.print("Enter Adhaar no : ");
      user.setAdhaar(sc.nextLine());

      System.out.println("Enter Address : ");
      user.setAddress(sc.nextLine());

      user.setRoomAlloted(0);
      user.setPartyHallAllotedl(0);
user.setMeetingHallAlloted(0);
      user.setBill(0);
      
      userDao.addUser(user);
   }

   void removeUser(String username, String password){
      User user = userDao.getUserByNameAndPassword(username, password);
      if(user != null){
         userDao.deleteUser(user);
      }
      else{
         System.out.println("User not found");
      }
   }
}

class UserManagement{
   UserDAO userDao = new UserDaoImpl();
   HotelDataDAO hotelDataDao = new HotelDataDaoImpl();
   HotelData hotel = hotelDataDao.getHotelData();

    void bookRoom(User user, int totalRoomToBeBooked){
      user.setRoomAlloted(user.getRoomAlloted() + totalRoomToBeBooked);
      user.setBill(user.getBill() + (totalRoomToBeBooked * 5200));
      userDao.bookRoom(user);

        int totalBookedRooms = hotel.getTotalBookedRoom() + totalRoomToBeBooked;
        hotel.setTotalBookedRoom(totalBookedRooms);
        hotelDataDao.updateTotalBookedRoom(hotel);
    }

    void orderFood(){

    }

    void organiseParty(User user, int totalPartyHallToBeBooked){
      user.setPartyHallAllotedl(user.getPartyHallAllotedl() + totalPartyHallToBeBooked);
      user.setBill(user.getBill() + (totalPartyHallToBeBooked * 70000));
      userDao.organiseParty(user);

      int totalBookedPartyHall = hotel.getTotalBookedPartyHall() + totalPartyHallToBeBooked;
      hotel.setTotalBookedPartyHall(totalBookedPartyHall);
      hotelDataDao.updateTotalBookedPartyHall(hotel);
    }

    void takeSwimmingPass(){

    }

    void bookMeetingHall(User user, int totalMeetingHallToBeBooked){
      user.setMeetingHallAlloted(user.getMeetingHallAlloted() + totalMeetingHallToBeBooked);
      user.setBill(user.getBill() + (totalMeetingHallToBeBooked * 20000));
      userDao.bookMeetingHall(user);

      int totalBookedMeetingHall = hotel.getTotalBookedMeetingHall() + totalMeetingHallToBeBooked;
      hotel.setTotalBookedMeetingHall(totalBookedMeetingHall);
      hotelDataDao.updateTotalBookedMeetingHall(hotel);
    }

    void takePlayzonePass(){

    }

    void takeGymPass(){
        
    }

    void updateUserProfile(User user){
      userDao.updateUserProfile(user);
    }
}