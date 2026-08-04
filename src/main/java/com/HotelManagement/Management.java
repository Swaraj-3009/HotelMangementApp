package com.HotelManagement;

import java.util.List;
import java.util.Scanner;

import com.DAO.UserDAO;
import com.DAO.Impl.UserDaoImpl;
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

      for(int i = 0; i<= u.size(); i++){
         System.out.println("| S.no : " + i + " | Name : " + u.get(i).getName() + " | Adhaar : " + u.get(i).getAdhaar() + " | Address : " + u.get(0).getAddress());
      }
   }

   void getUserByAdhaar(String adhaar){
      User u = userDao.getUserByAdhaar(adhaar);
      
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

    void bookRoom(User user, int totalRoomToBeBooked){
      user.setRoomAlloted(totalRoomToBeBooked);
      user.setBill(user.getBill() + (user.getRoomAlloted() * 1800));
      userDao.BookRoom(user);
    }

    void orderFood(){

    }

    void organiseParty(){

    }

    void takeSwimmingPass(){

    }

    void bookMeetingHall(){

    }

    void takePlayzonePass(){

    }

    void takeGymPass(){
        
    }

    void updateUserProfile(User user){
      userDao.updateUserProfile(user);
    }
}