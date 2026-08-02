package com.HotelManagement;

import java.util.Scanner;

import com.DAO.Impl.UserDaoImpl;
import com.HotelManagement.model.User;

class ManagerManagement{
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

   }
}

class BothAccessed{
   UserDaoImpl userDao = new UserDaoImpl();

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
    void bookRoom(){

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
}