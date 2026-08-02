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
   User user = new User();

   void addUser(String username, String Password, Scanner sc){
      user.setName(username);
      user.setPassword(Password);
      System.out.print("Enter Adhaar no : ");
      user.setAdhaar(sc.nextLine());
      System.out.println("Enter Address : ");
      user.setAddress(sc.nextLine());
      user.setRoomAlloted(0);
      user.setBill(0);
      
      userDao.addUser(user);
   }

   void removeUser(String username, String password){
      
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